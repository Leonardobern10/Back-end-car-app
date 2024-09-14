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
 * <p>
 * Este controlador expõe endpoints para realizar operações CRUD em carros e para buscar carros com base em diferentes
 * critérios como modelo, ano, valor, tipo de motor, velocidade máxima e características.
 * </p>
 */
@RestController
@RequestMapping( "/cars" )
public class CarsController {

    @Autowired
    private CarsService carsService;

    /**
     * Recupera todos os carros armazenados no banco de dados.
     * <p>
     * Este endpoint retorna uma lista contendo todos os carros registrados no banco de dados.
     * </p>
     *
     * @return uma lista de {@link Cars} contendo todos os carros registrados
     */
    @GetMapping
    public List<Cars> getAllCars () {
        return ResponseEntity.ok( carsService.getAllCars() ).getBody();
    }

    /**
     * Recupera um carro específico com base no ID fornecido.
     * <p>
     * Este endpoint retorna o carro associado ao ID fornecido.
     * </p>
     *
     * @param id o ID do carro a ser recuperado
     * @return um {@link ResponseEntity} contendo o carro encontrado e o status HTTP 200 (OK)
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @GetMapping( "/{id}" )
    public ResponseEntity<Cars> getById ( @PathVariable String id ) throws RuntimeException {
        return ResponseEntity.ok( carsService.getById( id ) );
    }

    /**
     * Cria um novo carro no banco de dados.
     * <p>
     * Este endpoint adiciona um novo carro ao banco de dados com base no objeto {@link Cars} passado no corpo da requisição.
     * </p>
     *
     * @param car o objeto {@link Cars} passado no corpo da requisição
     * @return um {@link ResponseEntity} contendo o carro salvo e o status HTTP 201 (Created)
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
     * <p>
     * Este endpoint atualiza o carro com o ID fornecido com base nas novas informações passadas no objeto {@link Cars}.
     * </p>
     *
     * @param id   o ID do carro a ser atualizado
     * @param cars o objeto {@link Cars} contendo os novos dados a serem aplicados
     * @return um {@link ResponseEntity} contendo o carro atualizado e o status HTTP 200 (OK)
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
     * <p>
     * Este endpoint remove o carro associado ao ID fornecido.
     * </p>
     *
     * @param id o ID do carro a ser removido
     * @return um {@link ResponseEntity} com o status HTTP 200 (OK) após a remoção bem-sucedida
     * @throws ResourceNotFoundException se o carro com o ID fornecido não for encontrado
     */
    @DeleteMapping( "/{id}" )
    public ResponseEntity<HttpStatus> deleteCar ( @PathVariable String id ) {
        carsService.deleteCar( id );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    /**
     * Recupera um carro com base no modelo fornecido.
     * <p>
     * Este endpoint retorna o carro associado ao modelo fornecido.
     * </p>
     *
     * @param model o modelo do carro a ser recuperado
     * @return o carro encontrado
     */
    @GetMapping( "/model" )
    public Cars getModels ( @RequestParam String model ) {
        return new ResponseEntity<>( carsService.getByModel( model ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com base no ano fornecido.
     * <p>
     * Este endpoint retorna todos os carros associados ao ano fornecido.
     * </p>
     *
     * @param year o ano dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/year" )
    public List<Cars> getByYear ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getByYear( year ), HttpStatus.OK ).getBody();
    }


    /**
     * Recupera carros mais novos que o ano fornecido.
     * <p>
     * Este endpoint retorna todos os carros produzidos depois do ano fornecido.
     * </p>
     *
     * @param year o ano a partir do qual os carros devem ser recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/year/newer_than" )
    public List<Cars> getNewerCars ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getNewerThanYear( year ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros mais antigos que o ano fornecido.
     * <p>
     * Este endpoint retorna todos os carros produzidos antes do ano fornecido.
     * </p>
     *
     * @param year o ano a partir do qual os carros devem ser recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/year/older_than" )
    public List<Cars> getOlderCars ( @RequestParam Integer year ) {
        return new ResponseEntity<>( carsService.getOlderThanYear( year ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros produzidos por uma determinada marca.
     * <p>
     * Este endpoint retorna todos os carros produzidos pela marca fornecida.
     * </p>
     *
     * @param producedBy a marca que produziu os carros
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/produced_by" )
    public List<Cars> getProducedBy ( @RequestParam String producedBy ) {
        return new ResponseEntity<>( carsService.getProducedBy( producedBy ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com base no valor fornecido.
     * <p>
     * Este endpoint retorna todos os carros com o valor exato fornecido.
     * </p>
     *
     * @param value o valor dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/value" )
    public List<Cars> getValue ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getByValue( value ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com valor maior que o valor fornecido.
     * <p>
     * Este endpoint retorna todos os carros com valor maior que o valor fornecido.
     * </p>
     *
     * @param value o valor mínimo dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/value/bigger_than" )
    public List<Cars> getValueBiggerThan ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getBiggerThanValue( value ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com valor menor que o valor fornecido.
     * <p>
     * Este endpoint retorna todos os carros com valor menor que o valor fornecido.
     * </p>
     *
     * @param value o valor máximo dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/value/less_than" )
    public List<Cars> getValueLessThan ( @RequestParam Double value ) {
        return new ResponseEntity<>( carsService.getByLessThanValue( value ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com base no tipo de motor fornecido.
     * <p>
     * Este endpoint retorna todos os carros com o tipo de motor fornecido.
     * </p>
     *
     * @param engineType o tipo de motor dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/engine_type" )
    public List<Cars> getEngineType ( @RequestParam String engineType ) {
        return new ResponseEntity<>( carsService.getByEngineType( engineType ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com base na velocidade máxima fornecida.
     * <p>
     * Este endpoint retorna todos os carros com a velocidade máxima fornecida.
     * </p>
     *
     * @param topSpeed a velocidade máxima dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/top_speed" )
    public List<Cars> getTopSpeed ( @RequestParam Integer topSpeed ) {
        return new ResponseEntity<>( carsService.getByTopSpeed( topSpeed ), HttpStatus.OK ).getBody();
    }

    /**
     * Recupera carros com base em uma característica fornecida.
     * <p>
     * Este endpoint retorna todos os carros que possuem a característica fornecida.
     * </p>
     *
     * @param feature a característica dos carros a serem recuperados
     * @return uma lista de carros encontrados
     */
    @GetMapping( "/feature" )
    public List<Cars> getFeature ( @RequestParam String feature ) {
        return new ResponseEntity<>( carsService.getByFeature( feature ), HttpStatus.OK ).getBody();
    }

}
