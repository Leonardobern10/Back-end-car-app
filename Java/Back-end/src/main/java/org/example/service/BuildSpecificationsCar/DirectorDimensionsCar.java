package org.example.service.BuildSpecificationsCar;

import org.example.model.DimensionsCar;

public class DirectorDimensionsCar {
    public static DimensionsCar construct ( BuilderDimensionsCar builderDimensionsCar, String length, String width, String height, String wheelBase ) {
        builderDimensionsCar.buildLength( length );
        builderDimensionsCar.buildWidth( width );
        builderDimensionsCar.buildHeight( height );
        builderDimensionsCar.buildWheelBase( wheelBase );
        return builderDimensionsCar.buildDimensionsCar();
    }
}
