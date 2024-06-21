package org.ZapikDimka;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface GenerateClass {
    String className(); // The name of the generated class
    String packageName(); // The package name for the generated class
    String[] fields() default {}; // Fields for the generated class in the format "type name"
    boolean generateConstructor() default true; // Whether to generate a default constructor
    boolean generateGettersSetters() default true; // Whether to generate getters and setters
}
