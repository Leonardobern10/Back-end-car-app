package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

public class TestRoutine {
    static int counter = 0;
    final Cars carsWithoutParams = new Cars();
    final Cars carsWithParams = new Cars("nameTest", "urlTest", 1500);
    final Cars car1 = new Cars("Model X", "http://example.com/modelx", 80000.0);
    final Cars car2 = new Cars("Model Y", "http://example.com/modely", 60000.0);
    final Cars car3 = new Cars("Model W", "http://example.com/modelw", 100000.0);
    String jsonModelX = "{\"model\":\"Model W\"," +
            "\"url\":\"http://example.com/modelw\",\"carValue\":100000.0}";
    String jsonModelY = "{\"model\":\"Model Y\",\"url\":\"http://example.com/modely\"," +
            "\"carValue\":60000.00}";
    String jsonModelW = "{\"model\":\"Model W\"," +
            "\"url\":\"http://example.com/modelw\",\"carValue\":100000.0}";

    List<Cars> allCars = Arrays.asList(car1, car2);

    @BeforeAll
    static void init() {
        System.out.println("Iniciando bateria de testes...");
    }

    @AfterAll
    static void finalizing() {
        System.out.println("Encerrando bateria de testes...");
        System.out.printf("%d testes executados!", counter);
    }

    @AfterEach
    void finalizingTest() {
        System.out.println("Finalizando teste..." + counter);
    }

    @BeforeEach
    void initTest() {
        counter++;
        System.out.println("Iniciando um novo teste... " + counter);
    }

}
