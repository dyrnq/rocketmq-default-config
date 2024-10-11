package com.dyrnq.sca;


//import org.apache.rocketmq.common.BrokerConfig;
//import org.apache.rocketmq.common.ControllerConfig;
//import org.apache.rocketmq.common.namesrv.NamesrvConfig;
//import org.apache.rocketmq.proxy.config.ProxyConfig;

import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static CaseInsensitiveMap<String, String> OVERWRITE_EMPTY_MAP = new CaseInsensitiveMap<>();

    static {
        OVERWRITE_EMPTY_MAP.put("brokerName", null);
        OVERWRITE_EMPTY_MAP.put("log", null);
        OVERWRITE_EMPTY_MAP.put("proxyName", null);
        OVERWRITE_EMPTY_MAP.put("localHostName", null);
        OVERWRITE_EMPTY_MAP.put("brokerIP1", null);
        OVERWRITE_EMPTY_MAP.put("brokerIP2", null);
//        OVERWRITE_EMPTY_MAP.put("jraftConfig", null);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, IOException {

        String className = args[0];
        String filePath = args[1];

        String format = "conf";

        if (args.length > 2) {
            format = args[2];
        }
        Map<String, Tuple3<Class<?>, Object, Boolean>> sortedMap = grabMap(className);
        //System.out.println(filePath);
        File file = new File(filePath);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        if ("conf".equalsIgnoreCase(format)) {
            for (Map.Entry<String, Tuple3<Class<?>, Object, Boolean>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Tuple3<Class<?>, Object, Boolean> value = entry.getValue();
                writer.write(key + "=" + value.v2);
                writer.newLine();
            }
            writer.flush();

        } else if ("md".equalsIgnoreCase(format)) {
            writer.write("|key|value|important|");
            writer.newLine();
            writer.write("|---|---|---|");
            writer.newLine();
            for (Map.Entry<String, Tuple3<Class<?>, Object, Boolean>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Tuple3<Class<?>, Object, Boolean> value = entry.getValue();
                writer.write("|" + key + "|" + value.v2 + "|" + (value.v3 ? "y" : "") + "|");
                writer.newLine();
            }
            writer.flush();

        } else if ("json".equalsIgnoreCase(format)) {
            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<String, Tuple3<Class<?>, Object, Boolean>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Tuple3<Class<?>, Object, Boolean> value = entry.getValue();
                jsonObject.set(key, value.v2);
            }

            writer.write(JSONUtil.toJsonPrettyStr(jsonObject));
            writer.flush();

        } else {
            System.err.println("NOT supported format, {conf,md,json} supported ");
        }


    }

//    public static Object newClassInstance(String className) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        Class<?> clazz = Class.forName(className);
//        Constructor<?> constructor = clazz.getConstructor();
//        Object classInstance = constructor.newInstance();
//        return classInstance;
//    }


    public static Map<String, Tuple3<Class<?>, Object, Boolean>> grabMap(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if ("org.apache.rocketmq.proxy.config.ProxyConfig".equalsIgnoreCase(className)) {
            try {
                Class<?> clazzConfigurationManager = Class.forName("org.apache.rocketmq.proxy.config.ConfigurationManager");
                ReflectUtil.invokeStatic(clazzConfigurationManager.getMethod("initEnv"));
                //ReflectUtil.invokeStatic(clazzConfigurationManager.getMethod("intConfig"));
            } catch (Exception e) {

            }
        }
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object classInstance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Tuple3<Class<?>, Object, Boolean>> unsortedMap = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            if (!hasPublicSetter(clazz, field)) {
                continue;
            }
            Object value = "";
            if (OVERWRITE_EMPTY_MAP.containsKey(key)) {

            } else {

                value = field.get(classInstance);
            }
            Tuple3<Class<?>, Object, Boolean> valueTuple;

            Class<?> fieldType = field.getType();
            boolean importantField = hasAnnotation(field, "org.apache.rocketmq.common.annotation.ImportantField");
            if (fieldType.equals(String.class)) {
                String valueStr = value != null ? value.toString() : "";
                String userHome = System.getProperty("user.home");
                valueStr = valueStr.replace("null/", "${ROCKETMQ_HOME}/");
                valueStr = valueStr.replace(userHome, "${user.home}");
                valueTuple = Tuple.tuple(fieldType, valueStr, importantField);
            } else {
                valueTuple = Tuple.tuple(fieldType, value, importantField);
            }


            unsortedMap.put(key, valueTuple);
        }

        //jraftConfig
        if ("org.apache.rocketmq.common.ControllerConfig".equalsIgnoreCase(className)){
            unsortedMap.remove("jraftConfig");
            Map<String, Tuple3<Class<?>, Object, Boolean>> jraftConfig = grabMap("org.apache.rocketmq.common.JraftConfig");
            for (Map.Entry<String, Tuple3<Class<?>, Object, Boolean>> entry : jraftConfig.entrySet()) {
                unsortedMap.put(entry.getKey(), entry.getValue());
            }
            unsortedMap.put("processReadEvent",unsortedMap.get("isProcessReadEvent"));
            unsortedMap.remove("isProcessReadEvent");
        }

        Map<String, Tuple3<Class<?>, Object, Boolean>> sortedMap = new TreeMap<>(unsortedMap);
        return sortedMap;
//        for (Map.Entry<String, Map<String,String>> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            Map<String,String> value = entry.getValue();
//
//            System.out.println(entry.getKey() + "=" + value.get(key));
//        }
    }

    public static boolean hasPublicSetter(Class<?> clazz, Field field) {
        String propertyName = field.getName();
        Class<?> fieldType = field.getType();
        if (clazz.getName().equalsIgnoreCase("org.apache.rocketmq.common.BrokerConfig")) {
            if ("defaultMessageRequestMode".equalsIgnoreCase(propertyName)) {
                fieldType = String.class;
            }
        }


        String setterName = "set" + capitalize(propertyName);

        try {
            Method method = clazz.getMethod(setterName, fieldType);
            return method != null;
        } catch (NoSuchMethodException e) {
            if (propertyName.startsWith("is")) {
                try {
                    setterName = StrUtil.replaceFirst(propertyName, "is", "set");
                    Method method = clazz.getMethod(setterName, fieldType);
                    return method != null;
                } catch (NoSuchMethodException e1) {
                    return false;
                }
            }else if(propertyName.startsWith("jRaft")){
                try {
                    setterName = StrUtil.replaceFirst(propertyName, "jRaft", "setjRaft");
                    Method method = clazz.getMethod(setterName, fieldType);
                    return method != null;
                } catch (NoSuchMethodException e1) {
                    return false;
                }
            }
            return false;
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private static boolean hasAnnotation(Field field, String annotationClassName) {

        Annotation[] fieldAnnotation = field.getAnnotations();
        boolean f = false;
        if (fieldAnnotation != null) {
            for (Annotation a : fieldAnnotation) {
                //System.out.println(a.annotationType().getCanonicalName());
                if (annotationClassName.equalsIgnoreCase(a.annotationType().getCanonicalName())) {
                    f = true;
                    break;
                }
            }
        }


        return f;
    }

}

