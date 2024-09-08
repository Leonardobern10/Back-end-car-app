package Cars;

import org.example.Main;
import org.example.exceptions.DuplicatedFoundException;
import org.example.exceptions.ResourceNotFoundException;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

/**
 * Testes para o controlador de carros.
 * Esta classe realiza testes de integração para os endpoints da API de carros,
 * garantindo que as operações CRUD estejam funcionando conforme o esperado.
 */
@SpringBootTest( classes = Main.class)
@AutoConfigureMockMvc
public class TestController extends TestRoutine {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarsService carsService;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Simula dados e comportamentos do serviço de carros.
     */
    @BeforeEach
    void setUp() {
        // Configurando dados simulados
        Cars car1 = new Cars("Model X", "http://example.com/modelx", 80000.0);
        Cars car2 = new Cars("Model Y", "http://example.com/modely", 60000.0);
        List<Cars> allCars = Arrays.asList(car1, car2);
        Cars car3 = new Cars("Model W", "http://example.com/modelw", 100000.0);

        // Configurando o mock para o serviço
        Mockito.when(carsService.getAllCars()).thenReturn(allCars);
        Mockito.when(carsService.getById(1)).thenReturn(allCars.get(0));
        Mockito.when(carsService.saveCar(Mockito.any(Cars.class))).thenReturn(car3);

        // Simular o comportamento esperado quando atualizar um registro de carro
        Mockito.when(carsService.buildUpdatedCar(Mockito.any(Cars.class), Mockito.anyString(), Mockito.anyString(), Mockito.anyDouble()))
                        .thenAnswer(invocation -> {
                            Cars car = invocation.getArgument(0);
                            car.setModel(invocation.getArgument(1));
                            car.setUrl(invocation.getArgument(2));
                            car.setCarValue(invocation.getArgument(3));
                            return car;
                        });

        // Simulando exceção de duplicação
        Mockito.doThrow(new DuplicatedFoundException("RESOURCE DUPLICATED"))
                .when(carsService).saveCar(Mockito.argThat(car -> car.getModel().equals("Model X")));
    }

    /**
     * Testa a recuperação bem-sucedida de todos os carros.
     * Verifica se o status da resposta é 200 OK e se o conteúdo da resposta corresponde à lista de carros esperada.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnAllCarsSuccessfully() throws Exception {
        // Realiza uma requisição GET para o endpoint /cars
        mockMvc.perform(get("/cars")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Verifica se o status da resposta é 200 OK
                .andExpect(content().json("[{\"model\":\"Model X\"," +
                        "\"url\":\"http://example.com/modelx\",\"carValue\":80000.00}," +
                        "{\"model\":\"Model Y\",\"url\":\"http://example.com/modely\"," +
                        "\"carValue\":60000.00}]"));  // Verifica o conteúdo da resposta
    }

    /**
     * Testa a recuperação bem-sucedida de um carro específico pelo ID.
     * Verifica se o status da resposta é 200 OK e se o conteúdo da resposta corresponde ao carro esperado.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnACars() throws Exception {
        mockMvc.perform(get("/cars/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"model\":\"Model X\"," +
                        "\"url\":\"http://example.com/modelx\",\"carValue\":80000.0}"));
    }

    /**
     * Testa a resposta para um ID de carro inválido.
     * Verifica se o status da resposta é 404 Not Found quando o carro não é encontrado.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnNotFoundIdCar() throws Exception {
        Mockito.when(carsService.getById(999)).thenThrow(new ResourceNotFoundException("ID INVÁLIDO"));
        mockMvc.perform(get("/cars/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    /**
     * Testa a criação bem-sucedida de um novo carro.
     * Verifica se o status da resposta é 201 Created e se o conteúdo da resposta corresponde ao carro criado.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldCreateCarSuccessfully() throws Exception {

        String newCarJson = "{\"model\":\"Model W\"," +
                "\"url\":\"http://example.com/modelw\",\"carValue\":100000.0}";

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newCarJson))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"model\":\"Model W\"," +
                        "\"url\":\"http://example.com/modelw\",\"carValue\":100000.0}"));

    }

    /**
     * Testa o retorno de um erro para um carro com modelo inválido.
     * Verifica se o status da resposta é 400 Bad Request quando o JSON enviado é inválido.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnBadRequestForInvalidModelCar() throws Exception {
        String invalidModelCarJson = "{\"model\":,\"url\":\"www.url.com\",\"carValue\":5000}";

        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidModelCarJson))
                .andExpect(status().isBadRequest());
    }

    /**
     * Testa o retorno de um erro para um carro com URL inválida.
     * Verifica se o status da resposta é 400 Bad Request quando o JSON enviado é inválido.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnBadRequestForInvalidUrlCar() throws Exception {
        String invalidUrlCarJson = "{\"model\":\"Teste model\",\"url\":,\"carValue\": 5000}";

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidUrlCarJson))
                .andExpect(status().isBadRequest());
    }

    /**
     * Testa o retorno de um erro para um carro com valor inválido.
     * Verifica se o status da resposta é 400 Bad Request quando o JSON enviado é inválido.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnBadRequestForInvalidCarValue() throws Exception {
        String invalidCarValueJson = "{\"model\":\"Teste model\",\"url\":\"url teste\",\"carValue\":\"}";

        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCarValueJson))
                .andExpect(status().isBadRequest());
    }

    /**
     * Testa a atualização bem-sucedida de um carro.
     * Verifica se o status da resposta é 200 OK e se o conteúdo da resposta corresponde ao carro atualizado.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldUpdateCar() throws Exception {
        String updatedCarJson = "{\"model\": \"Model Z\", \"url\": \"http://example.com/modelz\", \"carValue\": 90000.0}";

        mockMvc.perform(put("/cars/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedCarJson))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"model\":\"Model Z\",\"url\":\"http://example.com/modelz\",\"carValue\":90000.0}"));
    }

    /**
     * Testa a exclusão bem-sucedida de um carro.
     * Verifica se o status da resposta é 200 OK quando o carro é excluído com sucesso.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldDeleteCar() throws Exception {
        mockMvc.perform(delete("/cars/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Testa o retorno de um erro de conflito para a criação de um carro duplicado.
     * Verifica se o status da resposta é 409 Conflict e se o conteúdo da resposta indica duplicação.
     *
     * @throws Exception se ocorrer um erro na execução do teste
     */
    @Test
    void shouldReturnConflictForDuplicateCar() throws Exception {
        String duplicateCarJson = "{\"model\":\"Model X\",\"url\":\"http://example.com/modelx\",\"carValue\":80000.0}";
        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(duplicateCarJson))
                .andExpect(content().string("RESOURCE DUPLICATED"))
                .andExpect(status().isConflict());
    }
}
