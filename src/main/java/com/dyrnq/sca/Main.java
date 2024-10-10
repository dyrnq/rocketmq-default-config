package com.dyrnq.sca;


//import org.apache.rocketmq.common.BrokerConfig;
//import org.apache.rocketmq.common.ControllerConfig;
//import org.apache.rocketmq.common.namesrv.NamesrvConfig;
//import org.apache.rocketmq.proxy.config.ProxyConfig;

import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        OVERWRITE_EMPTY_MAP.put("jraftConfig", null);
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, IOException {

        String className = args[0];
        String filePath = args[1];

        String format = "conf";

        if (args.length > 2) {
            format = args[2];
        }
        Map<String, Map<String, Object>> sortedMap = grabMap(className);
        //System.out.println(filePath);
        File file = new File(filePath);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        if ("conf".equalsIgnoreCase(format)) {
            for (Map.Entry<String, Map<String, Object>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Map<String, Object> value = entry.getValue();
                writer.write(entry.getKey() + "=" + value.get(key));
                writer.newLine();
            }
            writer.flush();

        } else if ("md".equalsIgnoreCase(format)) {
            writer.write("|key|value|");
            writer.newLine();
            writer.write("|---|---|");
            writer.newLine();
            for (Map.Entry<String, Map<String, Object>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Map<String, Object> value = entry.getValue();
                writer.write("|" + entry.getKey() + "|" + value.get(key) + "|");
                writer.newLine();
            }
            writer.flush();

        } else if ("json".equalsIgnoreCase(format)) {
            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<String, Map<String, Object>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Map<String, Object> value = entry.getValue();
                jsonObject.set(key, value.get(key));
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


    public static Map<String, Map<String, Object>> grabMap(String className) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object classInstance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Map<String, Object>> unsortedMap = new HashMap<>();
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
            Map<String, Object> valueMap = new HashMap<>();

            Class<?> fieldType = field.getType();
            if(fieldType.equals(String.class)) {
                String valueStr = value != null ? value.toString() : "";
                String userHome = System.getProperty("user.home");
                valueStr = valueStr.replace("null/", "${ROCKETMQ_HOME}/");
                valueStr = valueStr.replace(userHome, "${ROCKETMQ_HOME}");
                valueMap.put(key, valueStr);
            }else{
                valueMap.put(key, value);
            }


            unsortedMap.put(key, valueMap);
        }
        Map<String, Map<String, Object>> sortedMap = new TreeMap<>(unsortedMap);
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

}

