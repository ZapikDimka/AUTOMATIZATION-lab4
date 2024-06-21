package org.ZapikDimka;

import org.ZapikDimka.ValidatePrice;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {

        try {
            // Create a new Car instance
            Car car = new Car("Toyota", "Japan", 25000.0);

            // Validate the price of the car
            PriceValidator.validatePrice(car);

            // Print the car details
            System.out.println(car);

            // Attempt to set a new price and validate it
            car.setPrice(20000.0);
            PriceValidator.validatePrice(car);

        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // Handle any validation errors
            System.err.println("Validation failed: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
