package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestClassCars extends TestRoutine {


    @Test
    @DisplayName("Verificando a instanciação da classe com e sem parâmetros...")
    void checkInstance() {
        assertAll(
                () -> assertNotNull(carsWithoutParams),
                () -> assertNotNull(carsWithParams)
        );
    }

    @Test
    @DisplayName("Verificando a geração aleatória de IDs...")
    void checkIdGeneration() {
        assertAll(
                () -> {
                assertInstanceOf(Integer.class, carsWithoutParams.getCarId());
                assertTrue(carsWithoutParams.getCarId() >= 0,
                    "ID deve ser sempre maior ou igual a zero.");
        }, () -> {
                assertInstanceOf(Integer.class, car1.getCarId());
                assertTrue(car1.getCarId() >= 0,
                    "ID deve ser sempre maior ou igual a zero.");
        });
    }

    @Test
    @DisplayName("Verificando a definição de modelos de carros...")
    void checkSetterModel() {
        car1.setModel("String inserida para test...");
        carsWithoutParams.setModel("String inserida para test...");
        assertAll(
                () -> assertEquals("String inserida para test...", car1.getModel()),
                () ->assertEquals("String inserida para test...", carsWithoutParams.getModel())
        );
    }

    @Test
    @DisplayName("Verificando a definição de URL...")
    void checkUrlDefinition() {
        car2.setUrl("URL para test...");
        carsWithoutParams.setUrl("URL para test...");
        assertAll(
                () -> assertEquals("URL para test...", car2.getUrl()),
                () -> assertEquals("URL para test...", carsWithoutParams.getUrl())
        );
    }

    @Test
    @DisplayName("Verificando a adição de valores para preços...")
    void checkValue() {
        car2.setCarValue(0);
        carsWithoutParams.setCarValue(0);
        assertAll(() -> {
            assertInstanceOf(Double.class, car2.getCarValue());
            assertEquals(0, car2.getCarValue());
        }, () -> {
            assertInstanceOf(Double.class, carsWithoutParams.getCarValue());
            assertEquals(0, carsWithoutParams.getCarValue());
        });
    }



}
