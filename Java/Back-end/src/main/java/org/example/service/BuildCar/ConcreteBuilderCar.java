package org.example.service.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.example.service.BuildDimensionsCar.ConcreteBuilderSpecificationsCar;
import org.example.service.BuildDimensionsCar.DirectorSpecificationsCar;
import org.example.service.BuildSpecificationsCar.ConcreteBuilderDimensionsCar;
import org.example.service.BuildSpecificationsCar.DirectorDimensionsCar;

import java.util.List;

public class ConcreteBuilderCar implements BuilderCar {

    Cars car;

    public ConcreteBuilderCar () {
        car = new Cars();
    }

    @Override
    public void buildModel ( String model ) {
        car.setModel( model );
    }

    @Override
    public void buildYearProduction ( Integer yearProduction ) {
        car.setYearProduction( yearProduction );
    }

    @Override
    public void buildProducedBy ( String producedBy ) {
        car.setProducedBy( producedBy );
    }

    @Override
    public void buildImageUrl ( String imageUrl ) {
        car.setImageUrl( imageUrl );
    }

    @Override
    public void buildCarValue ( Double carValue ) {
        car.setCarValue( carValue );
    }

    @Override
    public void buildSpecitifactions ( SpecificationsCar specificationsCar ) {
        ConcreteBuilderSpecificationsCar builderSpecificationsCar = new ConcreteBuilderSpecificationsCar();
        SpecificationsCar builtSpecifications = DirectorSpecificationsCar.construct(
                builderSpecificationsCar,
                specificationsCar.getEngineType(),
                specificationsCar.getEngineCapacity(),
                specificationsCar.getRange(),
                specificationsCar.getAcceleration(),
                specificationsCar.getTopSpeed()
        );
        car.setSpecifications( builtSpecifications );
    }

    @Override
    public void buildFeatures ( List<String> features ) {
        car.setFeatures( features );
    }

    @Override
    public void buildDimensions ( DimensionsCar dimensionsCar ) {
        ConcreteBuilderDimensionsCar builderDimensionsCar = new ConcreteBuilderDimensionsCar();
        DimensionsCar builtDimensions = DirectorDimensionsCar.construct(
                builderDimensionsCar,
                dimensionsCar.getLength(),
                dimensionsCar.getWidth(),
                dimensionsCar.getHeight(),
                dimensionsCar.getWheelBase()
        );
        car.setDimensions( builtDimensions );
    }

    @Override
    public Cars buildCar () {
        return car;
    }


}
