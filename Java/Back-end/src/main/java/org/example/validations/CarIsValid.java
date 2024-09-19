package org.example.validations;

import org.example.model.Cars;

public class CarIsValid {

    public static void validate ( Cars newCar ) {
        CarValidations carValidations = new CarValidations();
        carValidations.validateUpdatedInformations( newCar.getModel(), newCar.getYearProduction(),
                newCar.getProducedBy(), newCar.getImageUrl(),
                newCar.getCarValue(), newCar.getSpecifications(),
                newCar.getFeatures(), newCar.getDimensions() );
    }
}
