package Cars;

import org.example.model.Cars;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestRoutine {
    static int counter = 0;


    protected Cars carsWithoutParams;
    protected Cars carsWithParams;

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

        carsWithoutParams = new Cars();
        carsWithParams = new Cars ("Nome teste", "url teste", 150000.0);
    }

    @AfterEach
    void finalizingTest() {
        System.out.println("Finalizando teste..." + counter);
    }


}
