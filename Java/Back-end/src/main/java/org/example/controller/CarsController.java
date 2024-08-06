package org.example.controller;

import org.example.model.Cars;
import org.example.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @CrossOrigin( origins = "http://localhost:5173")
    @GetMapping
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }

    /**
     * {Param} Recebe o id de um registro.
     * Retorna o dado de um registro especifico do banco de dados.
     * */
    @CrossOrigin( origins = "http://localhost:5173")
    @GetMapping("/{id}")
    public Cars getById(@PathVariable int id) {
        return carsService.getById(id);
    }
}
