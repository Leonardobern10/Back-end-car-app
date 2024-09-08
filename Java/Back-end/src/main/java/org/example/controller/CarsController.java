package org.example.controller;

import org.example.model.Cars;
import org.example.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe responsável pelo gerenciamento de requisições.
 * */
@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    /**
     * Método que quando feita a requisição GET retorna os
     * dados de todos os registros do banco de dados.
     * */
    @GetMapping
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }

    /**
     * {Param} Recebe o id de um registro.
     * Retorna o dado de um registro especifico do banco de dados.
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Cars> getById(@PathVariable int id) throws RuntimeException {
        Cars car = carsService.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    /**
     * Permite a criação de um registro especifico no banco de dados.
     * */
    @PostMapping
    public ResponseEntity<Cars> createCar(@RequestBody Cars car) {
        Cars savedCar = carsService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    /**
     * {Params: id do elemento a ser atualizado; corpo contendo as propriedades do novo registro.}
     * Permite a atualização dos dados de um registro recuperado por seu id.
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Cars> updatedCar(@PathVariable int id, @RequestBody Cars cars) {
        Cars oldCar = carsService.getById(id);
        oldCar.setCar_id(id);
        oldCar.setModel(cars.getModel());
        oldCar.setUrl(cars.getUrl());
        oldCar.setCarValue(cars.getCarValue());
        carsService.saveCar(oldCar);
        return new ResponseEntity<>(oldCar, HttpStatus.OK);
    }

    /**
     * {Param} Numero inteiro representando o id de um registro.
     * Permite a remoção de um registro especifico no banco de dados.
     * */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable int id) {
        carsService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
