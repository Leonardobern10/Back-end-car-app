package org.example.build.BuildDimensionsCar;

import org.example.model.SpecificationsCar;

public class DirectorSpecificationsCar {
    public static SpecificationsCar construct ( BuilderSpecificationsCar builderSpecificationsCar, String engineType, String engineCapacity, String range, String acceleration, String topSpeed ) {
        builderSpecificationsCar.buildEngineType( engineType );
        builderSpecificationsCar.buildEngineCapacity( engineCapacity );
        builderSpecificationsCar.buildRange( range );
        builderSpecificationsCar.buildAcceleration( acceleration );
        builderSpecificationsCar.buildTopSpeed( topSpeed );
        return builderSpecificationsCar.buildSpecificationsCar();
    }
}
