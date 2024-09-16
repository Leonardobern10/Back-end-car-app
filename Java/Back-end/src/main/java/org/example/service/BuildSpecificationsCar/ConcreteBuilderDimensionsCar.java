package org.example.service.BuildSpecificationsCar;

import org.example.model.DimensionsCar;

public class ConcreteBuilderDimensionsCar implements BuilderDimensionsCar {

    DimensionsCar dimensionsCar;

    public ConcreteBuilderDimensionsCar () {
        dimensionsCar = new DimensionsCar();
    }

    @Override
    public void buildLength ( String length ) {
        dimensionsCar.setLength( length );
    }

    @Override
    public void buildWidth ( String width ) {
        dimensionsCar.setWidth( width );
    }

    @Override
    public void buildHeight ( String height ) {
        dimensionsCar.setHeight( height );
    }

    @Override
    public void buildWheelBase ( String wheelBase ) {
        dimensionsCar.setWheelBase( wheelBase );
    }

    @Override
    public DimensionsCar buildDimensionsCar () {
        return dimensionsCar;
    }
}
