package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRoutine {
    static int counter = 0;

    @Autowired
    final Cars carsWithoutParams = new Cars();

    @Autowired
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
