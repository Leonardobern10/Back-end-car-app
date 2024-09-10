package org.example.service;

import org.example.exceptions.*;
import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.validations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    /**
     * Injeta uma instância de carsRepository
     */
    @Autowired
    private CarsRepository carsRepository;

    /**
     * Injeta uma instância de carStringValidation
     */
    @Autowired
    private CarStringValidation carStringValidation;

    /**
     * Injeta uma instância de carValidations
     */
    @Autowired
    private CarValidations carValidations;

    /**
     * Injeta uma instância de carBuilder
     */
    @Autowired
    private CarBuilder carBuilder;

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
    public Optional<Cars> getById(int id) {
        try {
            carValidations.validateCarExistence(id);
            return carsRepository.findById(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
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
            carValidations.validateSaveCar(car, car.getModel(), car.getUrl(), car.getCarValue()); ;
            return carsRepository.save(car);
        } catch (FieldIntegerInvalidException | FieldStringInvalidException | FieldDoubleInvalidException | DuplicatedFoundException e) {
            throw e;  // Propaga a exceção para ser tratada pelo GlobalExceptionHandler
        }
    }

    /**
     * Remove um carro do banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser removido.
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado.
     */
    public void deleteCar(int id) {
        try {
            carValidations.validateCarExistence(id);
            carsRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        }
    }

    /**
     * Atualiza um carro existente no banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser atualizado.
     * @param car o objeto Cars contendo as informações atualizadas.
     * @return o objeto Cars atualizado que foi salvo no banco de dados.
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado.
     * @throws FieldStringInvalidException se o campo model ou url for inválido.
     * @throws FieldDoubleInvalidException se o valor do carro for inválido.
     * @throws FieldIntegerInvalidException se o campo ID for inválido.
     */
    public Cars updateCar(int id, Cars car) {
        try {
            carValidations.validateCarExistence(id);
            Cars oldCar = carsRepository.findById(id).orElseThrow();
            carValidations.validateUpdatedInformations(car.getModel(), car.getUrl(), car.getCarValue());
            Cars updatedCar = carBuilder.builder(oldCar, car.getModel(), car.getUrl(), car.getCarValue());
            return carsRepository.save(updatedCar);  // Salva o carro atualizado no banco de dados
        }catch (ResourceNotFoundException | FieldStringInvalidException | FieldDoubleInvalidException | FieldIntegerInvalidException e) {
            throw e;
        }
    }


}
