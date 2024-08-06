package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestClassCars {

    private static int counter = 0;
    private final Cars carsWithoutParams = new Cars();
    private final Cars carsWithParams = new Cars("nameTest", "urlTest", 1500);

    @BeforeAll
    static void init() {
        System.out.println("Iniciando bateria de testes...");
    }

    @AfterAll
    static void finalizing() {
        System.out.println("Encerrando bateria de testes...");
        System.out.printf("%d testes executados!", counter);
    }

    @BeforeEach
    void initTest() {
        counter++;
        System.out.println("Iniciando um novo teste... " + counter);
    }

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
                assertInstanceOf(Integer.class, carsWithParams.getCarId());
                assertTrue(carsWithParams.getCarId() >= 0,
                    "ID deve ser sempre maior ou igual a zero.");
        });
    }

    @Test
    @DisplayName("Verificando a definição de modelos de carros...")
    void checkSetterModel() {
        carsWithParams.setModel("String inserida para test...");
        carsWithoutParams.setModel("String inserida para test...");
        assertAll(
                () -> assertEquals("String inserida para test...", carsWithParams.getModel()),
                () ->assertEquals("String inserida para test...", carsWithoutParams.getModel())
        );
    }

    @Test
    @DisplayName("Verificando a definição de URL...")
    void checkUrlDefinition() {
        carsWithParams.setUrl("URL para test...");
        carsWithoutParams.setUrl("URL para test...");
        assertAll(
                () -> assertEquals("URL para test...", carsWithParams.getUrl()),
                () -> assertEquals("URL para test...", carsWithoutParams.getUrl())
        );
    }

    @Test
    @DisplayName("Verificando a adição de valores para preços...")
    void checkValue() {
        carsWithParams.setCarValue(0);
        carsWithoutParams.setCarValue(0);
        assertAll(() -> {
            assertInstanceOf(Double.class, carsWithParams.getCarValue());
            assertEquals(0, carsWithParams.getCarValue());
        }, () -> {
            assertInstanceOf(Double.class, carsWithoutParams.getCarValue());
            assertEquals(0, carsWithoutParams.getCarValue());
        });
    }

    @AfterEach
    void finalizingTest() {
        System.out.println("Finalizando teste..." + counter);
    }

}
