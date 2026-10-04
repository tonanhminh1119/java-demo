package com.myapp.Models.Entities.MathObjects;

public class Rectangle implements Shape {

    private double width;
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    private double height;
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * width;
    }
    
}
