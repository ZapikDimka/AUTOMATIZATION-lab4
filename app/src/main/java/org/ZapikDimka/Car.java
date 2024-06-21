package org.ZapikDimka;

import org.ZapikDimka.ValidatePrice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GenerateClass(className = "CarGEN", packageName = "org.ZapikDimka.generated", fields = {"String brand", "String origin", "double price"})
public class Car {

    private String brand;
    private String origin;
    private double price;

    public Car(String brand, String origin, double price) {
        this.brand = brand;
        this.origin = origin;
        setPrice(price);
    }

    public String getBrand() {
        return brand;
    }

    public String getOrigin() {
        return origin;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @ValidatePrice(min = 20000.0)
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
