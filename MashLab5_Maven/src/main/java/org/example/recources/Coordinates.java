package org.example.recources;

public class Coordinates {
    private float x;
    private double y; //Значение поля должно быть больше -885

    public Coordinates(){

    }

    public Coordinates(float x, double y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

