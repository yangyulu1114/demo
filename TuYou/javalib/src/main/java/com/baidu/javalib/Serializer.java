package com.baidu.javalib;

import java.lang.reflect.Field;

public class Serializer {

    public static String serializeObject(Object object) throws Exception {
        for (Class clazz : object.getClass().getInterfaces()) {
            System.out.println(clazz.getName());
        }
        StringBuilder sb = new StringBuilder();
        for (Field field : People.class.getDeclaredFields()) {
            System.out.println(String.format("%s %s", field.getType().getSimpleName(), field.getName()));

            sb.append(field.getType()).append("@").append(field.getName());

            if (field.getType().equals(String.class)) {
                sb.append(field.get(object)).append(",");
            } else if (field.getType().equals(int.class)) {
                sb.append((int) field.get(object)).append(",");
            } else {

            }
        }
        return sb.toString();
    }
}
