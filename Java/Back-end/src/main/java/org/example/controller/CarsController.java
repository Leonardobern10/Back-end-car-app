package org.example.controller;

import org.example.exceptions.*;
import org.example.model.Cars;
import org.example.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe responsável pelo gerenciamento de requisições relacionadas a carros.
 */
@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    /**
     * Recupera todos os carros armazenados no banco de dados.
     *
     * @return uma lista contendo todos os carros registrados no banco de dados.
     */
    @GetMapping
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }

    /**
     * Recupera um carro específico com base no ID fornecido.
     *
     * @param id o ID do carro a ser recuperado
     * @return ResponseEntity contendo o carro encontrado e o status HTTP 200 (OK)
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cars> getById(@PathVariable int id) throws RuntimeException {
        Cars car = carsService.getById(id).orElseThrow();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    /**
     * Cria um novo carro no banco de dados.
     *
     * @param car o objeto Cars passado no corpo da requisição
     * @return ResponseEntity contendo o carro salvo e o status HTTP 201 (Created)
     * @throws FieldIntegerInvalidException se o campo ID for inválido
     * @throws FieldStringInvalidException se algum campo de string for inválido
     * @throws FieldDoubleInvalidException se o valor do carro for inválido
     * @throws DuplicatedFoundException se um carro duplicado for encontrado
     */
    @PostMapping
    public ResponseEntity<Cars> createCar(@RequestBody Cars car) {
        Cars savedCar = carsService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    /**
     * Atualiza os dados de um carro existente com base no ID fornecido.
     *
     * @param id o ID do carro a ser atualizado
     * @param cars o objeto Cars contendo os novos dados a serem aplicados
     * @return ResponseEntity contendo o carro atualizado e o status HTTP 200 (OK)
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     * @throws FieldIntegerInvalidException se o campo ID for inválido
     * @throws FieldStringInvalidException se algum campo de string for inválido
     * @throws FieldDoubleInvalidException se o valor do carro for inválido
     * @throws DuplicatedFoundException se um carro duplicado for encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cars> updatedCar(@PathVariable int id, @RequestBody Cars cars) {
        Cars updatedCar = carsService.updateCar(id, cars);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    /**
     * Remove um carro específico do banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser removido
     * @return ResponseEntity com o status HTTP 200 (OK) após a remoção bem-sucedida
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id) {
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
