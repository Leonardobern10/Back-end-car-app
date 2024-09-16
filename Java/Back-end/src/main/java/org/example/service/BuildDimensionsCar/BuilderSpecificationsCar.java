package org.example.service.BuildDimensionsCar;

import org.example.model.SpecificationsCar;

public interface BuilderSpecificationsCar {
    void buildEngineType ( String engineType );

    void buildEngineCapacity ( String engineCapacity );

    void buildRange ( String range );

    void buildAcceleration ( String acceleration );

    void buildTopSpeed ( String topSpeed );

    SpecificationsCar buildSpecificationsCar ();
}
