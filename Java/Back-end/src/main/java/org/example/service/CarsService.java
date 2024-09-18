package org.example.service;

import org.example.model.Cars;
import org.example.repository.CarsRepository;
import org.example.build.BuildCar.ConcreteBuilderCar;
import org.example.build.BuildCar.DirectorCar;
import org.example.service.SearchDouble.SearchByBiggerValue;
import org.example.service.SearchDouble.SearchByLessValue;
import org.example.service.SearchDouble.SearchByValue;
import org.example.service.SearchInteger.SearchByNewerYear;
import org.example.service.SearchInteger.SearchByOlderYear;
import org.example.service.SearchInteger.SearchByYear;
import org.example.service.SearchString.*;
import org.example.service.context.ContextSearchCarsForInteger;
import org.example.service.context.ContextSearchCarsForString;
import org.example.service.context.ContextSearchCarsForValue;
import org.example.service.context.ContextSearchOneCarForString;
import org.example.validations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócios relacionada aos objetos {@link Cars}.
 * <p>
 * Esta classe fornece métodos para realizar operações CRUD (Criar, Ler, Atualizar, Excluir) e consultas específicas
 * relacionadas aos carros. Utiliza o repositório {@link CarsRepository} para interagir com o banco de dados e aplica
 * validações através das classes {@link CarValidations} e {@link StringValidation}.
 * </p>
 */
@Service
public class CarsService {

    private final DirectorCar directorCar;
    private final CarValidations carValidations;
    private final CarsRepository carsRepository;

    // For String
    ContextSearchOneCarForString contextByModel;
    ContextSearchOneCarForString contextById;
    ContextSearchCarsForString contextByFeature;
    ContextSearchCarsForString contextByProducedBy;
    ContextSearchCarsForString contextByEngineType;

    // For Double
    ContextSearchCarsForValue contextByValue;
    ContextSearchCarsForValue contextByBiggerValue;
    ContextSearchCarsForValue contextByLessValue;

    // For Integer
    ContextSearchCarsForInteger contextByYear;
    ContextSearchCarsForInteger contextByNewerYear;
    ContextSearchCarsForInteger contextByOlderYear;

    /**
     * Constrói uma instância do {@code CarsService} com os componentes necessários.
     *
     * @param carsRepository o repositório de carros para realizar operações de banco de dados
     * @param carValidations a classe de validações para carros
     * @param directorCar    o diretor responsável pela construção de carros
     */
    @Autowired
    public CarsService ( CarsRepository carsRepository, CarValidations carValidations, DirectorCar directorCar ) {
        this.carsRepository = carsRepository;
        this.carValidations = carValidations;
        this.directorCar = directorCar;

        this.contextByModel = new ContextSearchOneCarForString( new SearchByModel( carsRepository ) );
        this.contextById = new ContextSearchOneCarForString( new SearchById( carsRepository, carValidations ) );
        this.contextByValue = new ContextSearchCarsForValue( new SearchByValue( carsRepository ) );
        this.contextByBiggerValue = new ContextSearchCarsForValue( new SearchByBiggerValue( carsRepository ) );
        this.contextByLessValue = new ContextSearchCarsForValue( new SearchByLessValue( carsRepository ) );
        this.contextByYear = new ContextSearchCarsForInteger( new SearchByYear( carsRepository ) );
        this.contextByNewerYear = new ContextSearchCarsForInteger( new SearchByNewerYear( carsRepository ) );
        this.contextByOlderYear = new ContextSearchCarsForInteger( new SearchByOlderYear( carsRepository ) );
        this.contextByFeature = new ContextSearchCarsForString( new SearchByFeature( carsRepository ) );
        this.contextByProducedBy = new ContextSearchCarsForString( new SearchByProducedBy( carsRepository ) );
        this.contextByEngineType = new ContextSearchCarsForString( new SearchByEngineType( carsRepository ) );

    }

    /**
     * Recupera todos os carros armazenados no banco de dados.
     *
     * @return uma lista contendo todos os carros registrados no banco de dados.
     */
    public List<Cars> getAllCars () {
        List<Cars> cars = carsRepository.findAll();
        System.out.println( "Total de registros:" + cars.size() );
        return cars;
    }

    /**
     * Recupera um carro específico com base no modelo fornecido.
     *
     * @param model o modelo do carro a ser recuperado
     * @return o carro correspondente ao modelo fornecido
     */
    public Optional<Cars> getByModel ( String model ) {
        return contextByModel.doSearch( model );
    }

    /**
     * Recupera um carro específico com base no ID fornecido.
     *
     * @param id o ID do carro a ser recuperado
     * @return o carro correspondente ao ID fornecido
     * @throws RuntimeException se o carro com o ID fornecido não for encontrado
     */
    public Optional<Cars> getById ( String id ) {
        return contextById.doSearch( id );
    }

    /**
     * Recupera uma lista de carros com base no valor fornecido.
     *
     * @param value o valor dos carros a serem recuperados
     * @return uma lista de carros com o valor correspondente
     * @throws IllegalArgumentException se o valor fornecido for inválido
     */
    public List<Cars> getByValue ( Double value ) {
        return contextByValue.doSearch( value );
    }

    /**
     * Recupera uma lista de carros com valor menor que o fornecido.
     *
     * @param value o valor máximo dos carros a serem recuperados
     * @return uma lista de carros com valor menor que o fornecido
     * @throws IllegalArgumentException se o valor fornecido for inválido
     */
    public List<Cars> getByLessThanValue ( Double value ) {
        return contextByLessValue.doSearch( value );
    }

    /**
     * Recupera uma lista de carros com valor maior que o fornecido.
     *
     * @param value o valor mínimo dos carros a serem recuperados
     * @return uma lista de carros com valor maior que o fornecido
     * @throws IllegalArgumentException se o valor fornecido for inválido
     */
    public List<Cars> getBiggerThanValue ( Double value ) {
        return contextByBiggerValue.doSearch( value );
    }

    /**
     * Recupera uma lista de carros com base no ano de produção fornecido.
     *
     * @param year o ano de produção dos carros a serem recuperados
     * @return uma lista de carros com o ano de produção correspondente
     * @throws IllegalArgumentException se o ano fornecido for inválido
     */
    public List<Cars> getByYear ( Integer year ) {
        return contextByYear.doSearch( year );
    }

    /**
     * Recupera uma lista de carros produzidos após o ano fornecido.
     *
     * @param year o ano de produção mínimo dos carros a serem recuperados
     * @return uma lista de carros produzidos após o ano fornecido
     * @throws IllegalArgumentException se o ano fornecido for inválido
     */
    public List<Cars> getNewerThanYear ( Integer year ) {
        return contextByNewerYear.doSearch( year );
    }

    /**
     * Recupera uma lista de carros produzidos antes do ano fornecido.
     *
     * @param year o ano de produção máximo dos carros a serem recuperados
     * @return uma lista de carros produzidos antes do ano fornecido
     * @throws IllegalArgumentException se o ano fornecido for inválido
     */
    public List<Cars> getOlderThanYear ( Integer year ) {
        return contextByOlderYear.doSearch( year );
    }

    /**
     * Recupera uma lista de carros produzidos pelo fabricante fornecido.
     *
     * @param producedBy o nome do fabricante dos carros a serem recuperados
     * @return uma lista de carros produzidos pelo fabricante fornecido
     */
    public List<Cars> getProducedBy ( String producedBy ) {
        return contextByProducedBy.doSearch( producedBy );
    }

    /**
     * Recupera uma lista de carros com base no tipo de motor fornecido.
     *
     * @param engineType o tipo de motor dos carros a serem recuperados
     * @return uma lista de carros com o tipo de motor correspondente
     */
    public List<Cars> getByEngineType ( String engineType ) {
        return contextByEngineType.doSearch( engineType );
    }

    /**
     * Recupera uma lista de carros com base na característica fornecida.
     *
     * @param feature a característica dos carros a serem recuperados
     * @return uma lista de carros com a característica correspondente
     */
    public List<Cars> getByFeature ( String feature ) {
        return contextByFeature.doSearch( feature );
    }

    /**
     * Recupera uma lista de carros com base na velocidade máxima fornecida.
     *
     * @param topSpeed a velocidade máxima dos carros a serem recuperados, em milhas por hora (mph)
     * @return uma lista de carros com a velocidade máxima correspondente
     * @throws IllegalArgumentException se a velocidade fornecida for inválida
     */
    public List<Cars> getByTopSpeed ( Integer topSpeed ) {
        IntegerValidation.validate( topSpeed );
        String searchFormat = topSpeed.toString() + " mph";
        return carsRepository.findByTopSpeed( searchFormat );
    }

    /**
     * Salva um novo carro no banco de dados.
     *
     * @param car o objeto {@link Cars} a ser salvo
     * @return o carro salvo, incluindo o ID gerado
     * @throws RuntimeException se houver problemas ao validar ou salvar o carro
     */
    public Cars saveCar ( Cars car ) {
        ConcreteBuilderCar builderCar = new ConcreteBuilderCar();
        Cars newCar = directorCar.construct( builderCar, car.getModel(), car.getYearProduction(), car.getProducedBy(),
                car.getImageUrl(), car.getCarValue(), car.getSpecifications(),
                car.getFeatures(), car.getDimensions() );

        carValidations.validateUpdatedInformations( newCar.getModel(), newCar.getYearProduction(),
                newCar.getProducedBy(), newCar.getImageUrl(),
                newCar.getCarValue(), newCar.getSpecifications(),
                newCar.getFeatures(), newCar.getDimensions() );

        return carsRepository.save( newCar );
    }

    /**
     * Remove um carro específico do banco de dados com base no ID fornecido.
     *
     * @param id o ID do carro a ser removido
     * @throws RuntimeException se o carro com o ID fornecido não for encontrado
     */
    public void deleteCar ( String id ) {
        String str = FormatInfo.check( id );
        carValidations.validateCarExistence( str );
        carsRepository.deleteById( str );
    }

    /**
     * Atualiza os dados de um carro existente com base no ID fornecido.
     *
     * @param id  o ID do carro a ser atualizado
     * @param car o objeto {@link Cars} contendo os novos dados a serem aplicados
     * @return o carro atualizado
     * @throws RuntimeException se o carro com o ID fornecido não for encontrado ou se houver problemas ao validar os dados
     */
    public Cars updateCar ( String id, Cars car ) {
        Cars oldCar = carsRepository.findById( id )
                .orElseThrow( () -> new RuntimeException( "Car with ID " + id + " not found" ) );

        ConcreteBuilderCar builderCar = new ConcreteBuilderCar();
        Cars updatedCar = directorCar.construct( builderCar, car.getModel(), car.getYearProduction(), car.getProducedBy(),
                car.getImageUrl(), car.getCarValue(), car.getSpecifications(),
                car.getFeatures(), car.getDimensions() );

        // Validação após a construção do carro atualizado
        carValidations.validateUpdatedInformations( updatedCar.getModel(), updatedCar.getYearProduction(),
                updatedCar.getProducedBy(), updatedCar.getImageUrl(),
                updatedCar.getCarValue(), updatedCar.getSpecifications(),
                updatedCar.getFeatures(), updatedCar.getDimensions() );

        return carsRepository.save( updatedCar );
    }

}
