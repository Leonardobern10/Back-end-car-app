package org.example.validations;


import org.example.exceptions.DuplicatedFoundException;
import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DuplicatedFoundValidation {

    @Autowired
    private static CarsRepository carsRepository;

    @Autowired
    private final Cars car = new Cars();

    public static void validate (Cars car) {
        if (carsRepository.existsById(car.getCarId())){
            throw new DuplicatedFoundException("IT'S NOT POSSIBLE TO SAVE THAT DATA");
        }
    }
}
