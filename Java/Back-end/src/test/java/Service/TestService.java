package Service;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.service.CarsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TestService {

    @Autowired
    private CarsRepository carsRepository;

    @Test
    void whenSavedCars() {
        Cars cars = new Cars("Tesla", "string teste", 1800);

        carsRepository.save(cars);

        assertThat(carsRepository.findAll()).isNotEmpty();
    }

    @Test
    void whenFindById() {
        Cars car = new Cars("Teste nome", "Teste url", 0);
        carsRepository.save(car);

        Optional<Cars> found = carsRepository.findById(car.getCarId());

        assertThat(found).isPresent();
        assertThat(found.get().getCarId()).isEqualTo(car.getCarId());
    }

}
