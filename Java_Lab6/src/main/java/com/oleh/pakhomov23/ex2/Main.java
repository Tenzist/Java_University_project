package com.oleh.pakhomov23.ex2;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.print("Write name of class(with package): ");
        String className = new Scanner(System.in).next();
        try {
            Class<?> c = Class.forName(className);
            for (Method m : c.getMethods()) {
                System.out.printf("Name: %s Type: %s%n",
                        m.getName(), m.getReturnType().getCanonicalName());
                for (Class<?> type : m.getParameterTypes()) {
                    System.out.printf("Param type: %s%n",
                            type.getCanonicalName());
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error");
        }
    }
}