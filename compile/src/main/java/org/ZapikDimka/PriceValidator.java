package org.ZapikDimka;

import org.ZapikDimka.ValidatePrice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PriceValidator {


    public static void validatePrice(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        // Get all methods declared in the object's class
        Method[] methods = obj.getClass().getDeclaredMethods();

        // Iterate through each method
        for (Method method : methods) {
            // Check if the method is annotated with @ValidatePrice
            if (method.isAnnotationPresent(ValidatePrice.class)) {
                // Retrieve the annotation instance
                ValidatePrice validatePrice = method.getAnnotation(ValidatePrice.class);

                // Allow access to private methods
                method.setAccessible(true);

                // Construct the corresponding getter method for the property
                Method getter = obj.getClass().getMethod("get" + capitalize(method.getName().substring(3)));

                // Invoke the getter method to retrieve the price value
                double price = (double) getter.invoke(obj);

                // Check if the price is below the minimum allowed
                if (price < validatePrice.min()) {
                    throw new IllegalArgumentException("Price must be greater than or equal to " + validatePrice.min());
                }
            }
        }
    }


    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
