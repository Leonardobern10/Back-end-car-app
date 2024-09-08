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
     * Recupera todos os registros de carros armazenados no banco de dados.
     *
     * @return uma lista contendo todos os objetos Cars armazenados.
     */
    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

    /**
     * Recupera um registro de carro específico com base no ID fornecido.
     *
     * @param id o ID do carro a ser recuperado
     * @return o objeto Cars correspondente ao ID fornecido.
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado.
     */
    public Cars getById(int id) {
        return carsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("ID INVALIDO")
        );
    }

    /**
     * Salva um novo carro no banco de dados após realizar validações.
     *
     * @param car o objeto Cars a ser salvo no banco de dados
     * @return o objeto Cars que foi salvo no banco de dados.
     * @throws FieldIntegerInvalidException se o campo ID for inválido.
     * @throws FieldStringInvalidException se o campo model ou url for inválido.
     * @throws FieldDoubleInvalidException se o valor do carro for inválido.
     * @throws DuplicatedFoundException se um carro duplicado for encontrado.
     */
    public Cars saveCar(Cars car) {
        try {
            CarIdValidation.validate(car.getCarId());
            CarModelValidation.validate(car.getModel());
            CarUrlValidation.validate(car.getUrl());
            CarValueValidation.validate(car.getCarValue());
            DuplicatedFoundValidation.validate(car);
            return carsRepository.save(car);
        } catch (FieldIntegerInvalidException | FieldStringInvalidException | FieldDoubleInvalidException | DuplicatedFoundException e) {
            throw e;  // Propaga a exceção para ser tratada pelo GlobalExceptionHandler
        }
    }

    /**
     * Remove um carro do banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser removido.
     */
    public void deleteCar(int id) {
        carsRepository.deleteById(id);
    }

    /**
     * Atualiza os dados de um carro existente com os novos valores fornecidos.
     *
     * @param car o objeto Cars já existente a ser atualizado
     * @param model o novo modelo do carro
     * @param url a nova URL da imagem do carro
     * @param carValue o novo valor do carro
     * @return o objeto Cars atualizado.
     * @throws FieldStringInvalidException se o modelo ou a URL forem inválidos.
     * @throws FieldDoubleInvalidException se o valor do carro for inválido.
     */
    public Cars buildUpdatedCar(Cars car, String model, String url, double carValue) {
        try {
            CarModelValidation.validate(model);
            CarUrlValidation.validate(url);
            CarValueValidation.validate(carValue);
            car.setModel(model);
            car.setUrl(url);
            car.setCarValue(carValue);
            return car;
        } catch (FieldIntegerInvalidException | FieldStringInvalidException | FieldDoubleInvalidException | DuplicatedFoundException e) {
            throw e;  // Propaga a exceção para ser tratada pelo GlobalExceptionHandler
        }
    }
}
