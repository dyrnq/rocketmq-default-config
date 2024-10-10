package com.dyrnq.sca;

import java.lang.reflect.Constructor;

public class Check {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName(args[0]);
            Constructor<?> constructor = clazz.getConstructor();
            System.exit(0);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(198);
        }
    }
}
