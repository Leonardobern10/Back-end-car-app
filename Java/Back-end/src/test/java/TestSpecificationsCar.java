import org.example.model.SpecificationsCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSpecificationsCar extends TestRoutine {

    //Evitando a repetição de código
    public void checkParameters ( SpecificationsCar specificationsCar, String testEngineType,
                                  String testEngineCapacity, String testRange, String testAcceleration,
                                  String testTopSpeed ) {

        assertAll(
                () -> assertNotNull( specificationsCar ),
                () -> assertEquals( testEngineType, specificationsCar.getEngineType() ),
                () -> assertEquals( testEngineCapacity, specificationsCar.getEngineCapacity() ),
                () -> assertEquals( testRange, specificationsCar.getRange() ),
                () -> assertEquals( testAcceleration, specificationsCar.getAcceleration() ),
                () -> assertEquals( testTopSpeed, specificationsCar.getTopSpeed() )
        );
    }

    @Test
    void testInstance () {
        SpecificationsCar specificationsCar = initSpecificationsCar();

        checkParameters( specificationsCar, "engineType teste", "engineCapacity teste",
                "range teste", "acceleration teste", "topSpeed teste" );
    }

    @Test
    void testInstanceWithouParameters () {
        SpecificationsCar specificationsCar = buildSpecificationsCar();

        checkParameters( specificationsCar, "engineType teste", "engineCapacity teste",
                "range teste", "acceleration teste", "topSpeed teste" );
    }
}
