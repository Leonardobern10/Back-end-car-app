package org.example.model;


public class DimensionsCar {

    private String length;
    private String width;
    private String height;
    private String wheelBase;

    public DimensionsCar () {
    }

    public DimensionsCar ( String length, String width, String height, String wheelBase ) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.wheelBase = wheelBase;
    }

    public String getLength () {
        return length;
    }

    public void setLength ( String length ) {
        this.length = length;
    }

    public String getWidth () {
        return width;
    }

    public void setWidth ( String width ) {
        this.width = width;
    }

    public String getHeight () {
        return height;
    }

    public void setHeight ( String height ) {
        this.height = height;
    }

    public String getWheelBase () {
        return wheelBase;
    }

    public void setWheelBase ( String wheelBase ) {
        this.wheelBase = wheelBase;
    }
}
