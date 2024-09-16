package org.example.service.BuildDimensionsCar;

import org.example.model.SpecificationsCar;

public class ConcreteBuilderSpecificationsCar implements BuilderSpecificationsCar {
    SpecificationsCar specificationsCar = null;

    public ConcreteBuilderSpecificationsCar () {
        specificationsCar = new SpecificationsCar();
    }

    @Override
    public void buildEngineType ( String engineType ) {
        specificationsCar.setEngineType( engineType );
    }

    @Override
    public void buildEngineCapacity ( String engineCapacity ) {
        specificationsCar.setEngineCapacity( engineCapacity );
    }

    @Override
    public void buildRange ( String range ) {
        specificationsCar.setRange( range );
    }

    @Override
    public void buildAcceleration ( String acceleration ) {
        specificationsCar.setAcceleration( acceleration );
    }

    @Override
    public void buildTopSpeed ( String topSpeed ) {
        specificationsCar.setTopSpeed( topSpeed );
    }

    @Override
    public SpecificationsCar buildSpecificationsCar () {
        return specificationsCar;
    }
}
