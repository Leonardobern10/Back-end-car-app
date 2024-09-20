import org.example.model.DimensionsCar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDimensionsCar extends TestRoutine {

    public void checkParameters ( DimensionsCar dimensionsCar, String lengthTest, String widthTest,
                                  String heightTest, String wheelbaseTest ) {

        assertAll(
                () -> assertNotNull( dimensionsCar ),
                () -> assertEquals( lengthTest, dimensionsCar.getLength() ),
                () -> assertEquals( widthTest, dimensionsCar.getWidth() ),
                () -> assertEquals( heightTest, dimensionsCar.getHeight() ),
                () -> assertEquals( wheelbaseTest, dimensionsCar.getWheelBase() )
        );
    }

    @Test
    void testInstance () {
        DimensionsCar dimensionsCar = new DimensionsCar( "length teste", "width teste",
                "height teste", "wheelbase teste" );

        checkParameters( dimensionsCar, "length teste", "width teste", "height teste",
                "wheelbase teste" );
    }

    @Test
    void testInstanceWithoutParameters () {
        DimensionsCar dimensionsCar = buildDimensionsCar();

        checkParameters( dimensionsCar, "length teste", "width teste", "height teste",
                "wheelbase teste" );
    }
}
