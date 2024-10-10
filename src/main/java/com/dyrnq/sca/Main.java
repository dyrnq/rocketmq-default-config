package com.dyrnq.sca;


//import org.apache.rocketmq.common.BrokerConfig;
//import org.apache.rocketmq.common.ControllerConfig;
//import org.apache.rocketmq.common.namesrv.NamesrvConfig;
//import org.apache.rocketmq.proxy.config.ProxyConfig;

import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.json.JSONUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static CaseInsensitiveMap<String, String> SKIP_MAP = new CaseInsensitiveMap<>();

    static {
        SKIP_MAP.put("brokerName", null);
        SKIP_MAP.put("log", null);
        SKIP_MAP.put("proxyName", null);
        SKIP_MAP.put("localHostName", null);
        SKIP_MAP.put("brokerIP1", null);
        SKIP_MAP.put("brokerIP2", null);
        SKIP_MAP.put("jraftConfig", null);
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, IOException {

        String className = args[0];
        String filePath = args[1];

        String format = "conf";

        if (args.length > 2) {
            format = args[2];
        }
        Map<String, Map<String, String>> sortedMap = grabMap(className);
        //System.out.println(filePath);
        File file = new File(filePath);
        file.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        if ("conf".equalsIgnoreCase(format)) {
            for (Map.Entry<String, Map<String, String>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Map<String, String> value = entry.getValue();
                writer.write(entry.getKey() + "=" + value.get(key));
                writer.newLine();
            }
            writer.flush();

        } else if ("md".equalsIgnoreCase(format)) {
            writer.write("|key|value|");
            writer.newLine();
            writer.write("|---|---|");
            writer.newLine();
            for (Map.Entry<String, Map<String, String>> entry : sortedMap.entrySet()) {
                String key = entry.getKey();
                Map<String, String> value = entry.getValue();
                writer.write("|" + entry.getKey() + "|" + value.get(key) + "|");
                writer.newLine();
            }
            writer.flush();

        } else if ("json".equalsIgnoreCase(format)) {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            Object classInstance = constructor.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String key = field.getName();
                if (SKIP_MAP.containsKey(key)) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.set(classInstance, "");
                    }
                }
            }
//            System.out.println(JSONUtil.toJsonPrettyStr(classInstance));

//            null/
            String json = JSONUtil.toJsonPrettyStr(classInstance);
            String userHome = System.getProperty("user.home");
            json = json.replace("null/","${ROCKETMQ_HOME}/");
            json = json.replace(userHome,"${ROCKETMQ_HOME}");
            writer.write(json);
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


    public static Map<String, Map<String, String>> grabMap(String className) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Object classInstance = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Map<String, String>> unsortedMap = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = "";
            if (SKIP_MAP.containsKey(key)) {

            } else {

                value = field.get(classInstance);
            }
            Map<String, String> valueMap = new HashMap<>();

            String valueStr = value != null ? value.toString() : "";
            String userHome = System.getProperty("user.home");
            valueStr = valueStr.replace("null/","${ROCKETMQ_HOME}/");
            valueStr = valueStr.replace(userHome,"${ROCKETMQ_HOME}");



            valueMap.put(key, valueStr);
            unsortedMap.put(key, valueMap);
        }
        Map<String, Map<String, String>> sortedMap = new TreeMap<>(unsortedMap);
        return sortedMap;
//        for (Map.Entry<String, Map<String,String>> entry : sortedMap.entrySet()) {
//            String key = entry.getKey();
//            Map<String,String> value = entry.getValue();
//
//            System.out.println(entry.getKey() + "=" + value.get(key));
//        }
    }
}

