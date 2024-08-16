package Cars;

import org.example.Main;
import org.example.service.CarsService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.example.model.Cars;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@SpringBootTest( classes = Main.class)
@AutoConfigureMockMvc
public class TestController extends TestRoutine {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsService carsService;

    @BeforeEach
    void setUp() {
        // Configurando o mock para o serviço
        Mockito.when(carsService.getAllCars()).thenReturn(allCars);
        Mockito.when(carsService.getById(1)).thenReturn(allCars.getFirst());
        Mockito.when(carsService.saveCar(Mockito.any(Cars.class))).thenReturn(car3);
    }

    @Test
    void shouldReturnAllCars() throws Exception {
        // Realiza uma requisição GET para o endpoint /cars
        mockMvc.perform(get("/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Verifica se o status da resposta é 200 OK
                .andExpect(content().json("[{\"model\":\"Model X\"," +
                        "\"url\":\"http://example.com/modelx\",\"carValue\":80000.00}," +
                        "{\"model\":\"Model Y\",\"url\":\"http://example.com/modely\"," +
                        "\"carValue\":60000.00}]"));  // Verifica o conteúdo da resposta
    }

    @Test
    void shouldReturnACars() throws Exception {
        mockMvc.perform(get("/cars/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"model\":\"Model X\"," +
                        "\"url\":\"http://example.com/modelx\",\"carValue\":80000.0}"));
    }

    @Test
    void shouldSaveCars() throws Exception {

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonModelW))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"model\":\"Model W\"," +
                        "\"url\":\"http://example.com/modelw\",\"carValue\":100000.0}"));

    }


}
