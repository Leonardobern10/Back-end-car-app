package org.example.build.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectorCar {
    public Cars construct ( BuilderCar builderCar, String model, Integer yearProduction, String producedBy, String imageUrl,
                            Double carValue, SpecificationsCar specificationsCar, List<String> features,
                            DimensionsCar dimensionsCar ) {
        builderCar.buildModel( model );
        builderCar.buildYearProduction( yearProduction );
        builderCar.buildProducedBy( producedBy );
        builderCar.buildImageUrl( imageUrl );
        builderCar.buildCarValue( carValue );
        builderCar.buildSpecitifactions( specificationsCar );
        builderCar.buildFeatures( features );
        builderCar.buildDimensions( dimensionsCar );
        return builderCar.buildCar();
    }
}
