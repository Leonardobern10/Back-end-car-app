package org.example.service;

import org.example.exceptions.*;
import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.validations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    /**
     * Injeta uma instância de carsRepository
     */
    @Autowired
    private CarsRepository carsRepository;

    /**
     * Função que retorna todos os registros do banco de dados.
     */
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }


    /**
     * {param} Recebe o id de um registro do banco de dados.
     * Retorna um registro específico do banco de dados.
     */
    public Cars getById(int id) {
        return carsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ID INVALIDO")
        );
    }

    public Cars saveCar(Cars car) {
        try {
            CarIdValidation.validate(car.getCarId());
            CarModelValidation.validate(car.getModel());
            CarUrlValidation.validate(car.getUrl());
            CarValueValidation.validate(car.getCarValue());
            DuplicatedFoundValidation.validate(car);
            Cars newCar = carsRepository.save(car);
            return carsRepository.save(car);
        } catch (FieldIntegerInvalid | FieldStringInvalid | FieldDoubleInvalid | DuplicatedFoundException e) {
            throw e;  // Propaga a exceção para ser tratada pelo GlobalExceptionHandler
        }
    }


    public void deleteCar(int id) {
        carsRepository.deleteById(id);
    }
}
