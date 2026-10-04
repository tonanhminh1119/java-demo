package com.myapp.Models.Entities.MathObjects;
public interface Shape {
    double getArea();

    default void describe() {
        System.out.println("Area: " + getArea());
    }
}

