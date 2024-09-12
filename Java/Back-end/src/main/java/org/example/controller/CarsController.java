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
@RequestMapping( "/cars" )
public class CarsController {

    @Autowired
    private CarsService carsService;

    /**
     * Recupera todos os carros armazenados no banco de dados.
     *
     * @return uma lista contendo todos os carros registrados no banco de dados.
     */
    @GetMapping
    public List<Cars> getAllCars () {
        return new ResponseEntity<>( carsService.getAllCars(), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera um carro específico com base no ID fornecido.
     *
     * @param id o ID do carro a ser recuperado
     * @return ResponseEntity contendo o carro encontrado e o status HTTP 200 (OK)
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @GetMapping( "/{id}" )
    public ResponseEntity<Cars> getById ( @PathVariable String id ) throws RuntimeException {
        return ResponseEntity.ok( carsService.getById( id ) );
    }

    /**
     * Cria um novo carro no banco de dados.
     *
     * @param car o objeto Cars passado no corpo da requisição
     * @return ResponseEntity contendo o carro salvo e o status HTTP 201 (Created)
     * @throws FieldIntegerInvalidException se o campo ID for inválido
     * @throws FieldStringInvalidException  se algum campo de string for inválido
     * @throws FieldDoubleInvalidException  se o valor do carro for inválido
     * @throws DuplicatedFoundException     se um carro duplicado for encontrado
     */
    @PostMapping
    public ResponseEntity<Cars> createCar ( @RequestBody Cars car ) {
        return ResponseEntity.ok( carsService.saveCar( car ) );
    }

    /**
     * Atualiza os dados de um carro existente com base no ID fornecido.
     *
     * @param id   o ID do carro a ser atualizado
     * @param cars o objeto Cars contendo os novos dados a serem aplicados
     * @return ResponseEntity contendo o carro atualizado e o status HTTP 200 (OK)
     * @throws ResourceNotFoundException    se o carro com o ID fornecido não for encontrado
     * @throws FieldIntegerInvalidException se o campo ID for inválido
     * @throws FieldStringInvalidException  se algum campo de string for inválido
     * @throws FieldDoubleInvalidException  se o valor do carro for inválido
     * @throws DuplicatedFoundException     se um carro duplicado for encontrado
     */
    @PutMapping( "/{id}" )
    public ResponseEntity<Cars> updatedCar ( @PathVariable String id, @RequestBody Cars cars ) {
        return ResponseEntity.ok( carsService.updateCar( id, cars ) );
    }

    /**
     * Remove um carro específico do banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser removido
     * @return ResponseEntity com o status HTTP 200 (OK) após a remoção bem-sucedida
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @DeleteMapping( "/{id}" )
    public ResponseEntity<HttpStatus> deleteCar ( @PathVariable String id ) {
        carsService.deleteCar( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    @GetMapping( "/model" )
    public Cars getModels ( @RequestParam String model ) {
        return new ResponseEntity<>( carsService.getByModel( model ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/year" )
    public List<Cars> getByYear ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getByYear( year ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/year/newer_than" )
    public List<Cars> getNewerCars ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getNewerThanYear( year ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/year/older_than" )
    public List<Cars> getOlderCars ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getOlderThanYear( year ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/produced_by" )
    public List<Cars> getProducedBy ( @RequestParam String producedBy ) {
        return new ResponseEntity<>( carsService.getProducedBy( producedBy ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/value" )
    public List<Cars> getValue ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getByValue( value ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/value/bigger_than" )
    public List<Cars> getValueBiggerThan ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getBiggerThanValue( value ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/value/less_than" )
    public List<Cars> getValueLessThan ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getByLessThanValue( value ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/engine_type" )
    public List<Cars> getEngineType ( @RequestParam String engineType ) {
        return new ResponseEntity<>( carsService.getByEngineType( engineType ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/top_speed" )
    public List<Cars> getTopSpeed ( @RequestParam Integer topSpeed ) {
        return new ResponseEntity<>( carsService.getByTopSpeed( topSpeed ), HttpStatus.OK ).getBody();
    }

    @GetMapping( "/feature" )
    public List<Cars> getFeature ( @RequestParam String feature ) {
        return new ResponseEntity<>( carsService.getByFeature( feature ), HttpStatus.OK ).getBody();
    }

}
