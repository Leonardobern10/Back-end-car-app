package org.example.build.BuildSpecificationsCar;

import org.example.model.DimensionsCar;

public interface BuilderDimensionsCar {
    void buildLength ( String lentgh );

    void buildWidth ( String width );

    void buildHeight ( String height );

    void buildWheelBase ( String wheelBase );

    DimensionsCar buildDimensionsCar ();
}
