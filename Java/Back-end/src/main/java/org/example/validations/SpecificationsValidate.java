package org.example.validations;

import org.example.model.SpecificationsCar;

public class SpecificationsValidate {
    public static void validate ( SpecificationsCar specificationsCar ) {
        isValid( specificationsCar.getEngineType() );
        isValid( specificationsCar.getEngineCapacity() );
        isValid( specificationsCar.getRange() );
        isValid( specificationsCar.getAcceleration() );
        isValid( specificationsCar.getTopSpeed() );
    }

    private static void isValid ( String string ) {
        CarStringValidation.validate( string, "FIELD IS NOT VALID" + string );
    }
}
