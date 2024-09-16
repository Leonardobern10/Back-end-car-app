package org.example.service.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;

import java.util.List;

public interface BuilderCar {

    void buildModel ( String model );

    void buildYearProduction ( Integer yearProduction );

    void buildProducedBy ( String producedBy );

    void buildImageUrl ( String imageUrl );

    void buildCarValue ( Double carValue );

    void buildSpecitifactions ( SpecificationsCar specificationsCar );

    void buildFeatures ( List<String> features );

    void buildDimensions ( DimensionsCar dimensionsCar );

    Cars buildCar ();
}
