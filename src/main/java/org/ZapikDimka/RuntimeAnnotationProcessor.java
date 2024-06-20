package org.ZapikDimka;

import org.ZapikDimka.annotations.RuntimeAnnotation;

import java.lang.reflect.Method;

public class RuntimeAnnotationProcessor {
    public static void processAnnotations(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(RuntimeAnnotation.class)) {
                RuntimeAnnotation annotation = method.getAnnotation(RuntimeAnnotation.class);
                System.out.println("Method: " + method.getName() + ", Annotation value: " + annotation.value());

                try {
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
