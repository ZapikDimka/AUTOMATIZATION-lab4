package org.ZapikDimka;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidatePrice {
    double min() default 0.0; // Minimum price value
    String message() default "Price must be greater than or equal to"; // Error message
}
