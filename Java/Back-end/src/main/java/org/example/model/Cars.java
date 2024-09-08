package org.example.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

/**
 * Classe representativa dos dados armazenados no banco de dados
 * */
@Component
@Entity( name = "cars" )
@Table( name = "cars" )
public class Cars {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private int carId;
    private String model;
    private String url;
    private double carValue;

    public Cars () {};

    public Cars (String model, String url, double carValue) {
        this.model = model;
        this.url = url;
        this.carValue = carValue;
    }

    public int getCarId() {
        return carId;
    }

    public void setCar_id(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getCarValue() {
        return carValue;
    }

    public void setCarValue(double carValue) {
        this.carValue = carValue;
    }
}
