package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestRoutine {
    static int counter = 0;
    final Cars carsWithoutParams = new Cars();
    final Cars carsWithParams = new Cars("nameTest", "urlTest", 1500);

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
