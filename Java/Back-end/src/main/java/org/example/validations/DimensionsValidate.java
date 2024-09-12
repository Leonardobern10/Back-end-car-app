package org.example.validations;

import org.example.model.DimensionsCar;

public class DimensionsValidate {
    public static void validate ( DimensionsCar dimensionsCar ) {
        isValid( dimensionsCar.getLength() );
        isValid( dimensionsCar.getWidth() );
        isValid( dimensionsCar.getHeight() );
        isValid( dimensionsCar.getWheelBase() );
    }

    private static void isValid ( String string ) {
        CarStringValidation.validate( string, "FIELD IS NOT VALID" + string );
    }
}
