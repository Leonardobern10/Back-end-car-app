package org.example.service;

import org.example.build.BuildCar.ConcreteBuilderCar;
import org.example.build.BuildCar.DirectorCar;
import org.example.model.Cars;

public class ConstructCar {
    public static Cars construct ( Cars car ) {
        ConcreteBuilderCar builderCar = new ConcreteBuilderCar();
        DirectorCar directorCar = new DirectorCar();
        Cars updatedCar = directorCar.construct( builderCar, car.getModel(), car.getYearProduction(),
                car.getProducedBy(), car.getImageUrl(), car.getCarValue(), car.getSpecifications(),
                car.getFeatures(), car.getDimensions() );
        return car;
    }
}
