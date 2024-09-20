import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestCars extends TestRoutine {

    public void checkParameters ( Cars car, String testModel, Integer testYearProduction,
                                  String testProducedBy, String testImageUrl, Double testCarValue,
                                  SpecificationsCar testSpecificationsCar, List<String> testFeatures,
                                  DimensionsCar testDimensionsCar ) {

        assertAll(
                () -> assertNotNull( car ),
                () -> assertEquals( "model teste", car.getModel() ),
                () -> assertEquals( 0, car.getYearProduction() ),
                () -> assertEquals( "produced teste", car.getProducedBy() ),
                () -> assertEquals( "image teste", car.getImageUrl() ),
                () -> assertEquals( 0.0, car.getCarValue() ),
                () -> assertNotNull( car.getSpecifications() ),
                () -> assertNotNull( car.getFeatures() ),
                () -> assertNotNull( car.getDimensions() )
        );
    }

    @Test
    @DisplayName( "Testando a instanciação da classe Cars com e sem parâmetros" )
    void testCarInstanceWithParamaters () {
        // Teste com parâmetros
        List<String> features = initFeatures( "feature1Test", "feature2Test" );
        DimensionsCar dimensionsCar = initDimensionsCar();
        SpecificationsCar specificationsCar = initSpecificationsCar();

        Cars carWithParams = new Cars( "model teste", 0, "produced teste", "image teste", 0.0, specificationsCar, features, dimensionsCar );

        checkParameters( carWithParams, "model teste", 0,
                "produced teste", "image teste", 0.0,
                specificationsCar, features, dimensionsCar );
    }

    @Test
    void testCarIstanceWithoutParameters () {
        List<String> features = initFeatures( "feature1Test", "feature2Test" );
        DimensionsCar dimensionsCar = initDimensionsCar();
        SpecificationsCar specificationsCar = initSpecificationsCar();

        Cars carWithoutParams = buildCarWithoutParameters();

        carWithoutParams.setSpecifications( specificationsCar );
        carWithoutParams.setFeatures( features );
        carWithoutParams.setDimensions( dimensionsCar );

        checkParameters( carWithoutParams, "model teste", 0,
                "produced teste", "image teste", 0.0,
                specificationsCar, features, dimensionsCar );
    }
}
