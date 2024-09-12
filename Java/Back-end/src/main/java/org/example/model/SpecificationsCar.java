package org.example.model;

public class SpecificationsCar {

    private String engineType;
    private String engineCapacity;
    private String range;
    private String acceleration;
    private String topSpeed;

    public SpecificationsCar () {
    }

    public SpecificationsCar ( String engineType, String engineCapacity, String range, String acceleration, String topSpeed ) {
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
        this.range = range;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
    }

    public String getEngineType () {
        return engineType;
    }

    public void setEngineType ( String engineType ) {
        this.engineType = engineType;
    }

    public String getEngineCapacity () {
        return engineCapacity;
    }

    public void setEngineCapacity ( String engineCapacity ) {
        this.engineCapacity = engineCapacity;
    }

    public String getRange () {
        return range;
    }

    public void setRange ( String range ) {
        this.range = range;
    }

    public String getAcceleration () {
        return acceleration;
    }

    public void setAcceleration ( String acceleration ) {
        this.acceleration = acceleration;
    }

    public String getTopSpeed () {
        return topSpeed;
    }

    public void setTopSpeed ( String topSpeed ) {
        this.topSpeed = topSpeed;
    }
}
