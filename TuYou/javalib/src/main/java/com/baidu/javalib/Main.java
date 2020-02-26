package com.baidu.javalib;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) throws Exception {
        for (Field field : People.class.getDeclaredFields()) {
            System.out.println(String.format("%s %s", field.getType().getSimpleName(), field.getName()));
        }

        for (Method method : People.class.getDeclaredMethods()) {
            StringBuilder sb = new StringBuilder();
            sb.append(method.getReturnType().getSimpleName()).append(" ");
            sb.append(method.getName()).append("(");
            for (Parameter parameter : method.getParameters()) {
                sb.append(parameter.getType().getSimpleName()).append(" ");
                sb.append(parameter.getName()).append(", ");
            }
            if (method.getParameters().length > 0) {
                sb.setLength(sb.length() - 2);
            }
            sb.append(")");
            System.out.println(sb.toString());
        }

        People people = new People();
        Field field = People.class.getDeclaredField("work");
        field.setAccessible(true);
        field.set(people, "hello");
        System.out.println(people.toString());

        Method method = People.class.getDeclaredMethod("setWork", String.class);
        method.setAccessible(true);
        method.invoke(people, "china");
        System.out.println(people.toString());

        Constructor constructor = People.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        People people1 = (People) constructor.newInstance("world");
        System.out.println(people1.toString());

        Man man = new Man();
        Serializer.serializeObject(man);
    }

}
