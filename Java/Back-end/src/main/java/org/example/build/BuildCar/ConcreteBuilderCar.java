package org.example.build.BuildCar;

import org.example.model.Cars;
import org.example.model.DimensionsCar;
import org.example.model.SpecificationsCar;
import org.example.build.BuildSpecificationsCar.ConcreteBuilderSpecificationsCar;
import org.example.build.BuildSpecificationsCar.DirectorSpecificationsCar;
import org.example.build.BuildDimensionsCar.ConcreteBuilderDimensionsCar;
import org.example.build.BuildDimensionsCar.DirectorDimensionsCar;

import java.util.List;

/**
 * Implementação concreta do construtor de carros, que cria e configura um objeto {@link Cars}
 * através dos métodos fornecidos na interface {@link BuilderCar}.
 */
public class ConcreteBuilderCar implements BuilderCar {

    Cars car;

    /**
     * Cria uma nova instância de {@link ConcreteBuilderCar} e inicializa o objeto {@link Cars}.
     */
    public ConcreteBuilderCar () {
        car = new Cars();
    }

    /**
     * Define o modelo do carro.
     *
     * @param model o modelo do carro
     */
    @Override
    public void buildModel ( String model ) {
        car.setModel( model );
    }

    /**
     * Define o ano de produção do carro.
     *
     * @param yearProduction o ano de produção do carro
     */
    @Override
    public void buildYearProduction ( Integer yearProduction ) {
        car.setYearProduction( yearProduction );
    }

    /**
     * Define o fabricante do carro.
     *
     * @param producedBy o fabricante do carro
     */
    @Override
    public void buildProducedBy ( String producedBy ) {
        car.setProducedBy( producedBy );
    }

    /**
     * Define a URL da imagem do carro.
     *
     * @param imageUrl a URL da imagem do carro
     */
    @Override
    public void buildImageUrl ( String imageUrl ) {
        car.setImageUrl( imageUrl );
    }

    /**
     * Define o valor do carro.
     *
     * @param carValue o valor do carro
     */
    @Override
    public void buildCarValue ( Double carValue ) {
        car.setCarValue( carValue );
    }


    /**
     * Define as especificações do carro utilizando {@link ConcreteBuilderSpecificationsCar} e {@link DirectorSpecificationsCar}.
     *
     * @param specificationsCar as especificações do carro
     */
    @Override
    public void buildSpecitifactions ( SpecificationsCar specificationsCar ) {
        ConcreteBuilderSpecificationsCar builderSpecificationsCar = new ConcreteBuilderSpecificationsCar();
        SpecificationsCar builtSpecifications = DirectorSpecificationsCar.construct(
                builderSpecificationsCar,
                specificationsCar.getEngineType(),
                specificationsCar.getEngineCapacity(),
                specificationsCar.getRange(),
                specificationsCar.getAcceleration(),
                specificationsCar.getTopSpeed()
        );
        car.setSpecifications( builtSpecifications );
    }

    /**
     * Define as características do carro.
     *
     * @param features uma lista com as características do carro
     */
    @Override
    public void buildFeatures ( List<String> features ) {
        car.setFeatures( features );
    }

    /**
     * Define as dimensões do carro utilizando {@link ConcreteBuilderDimensionsCar} e {@link DirectorDimensionsCar}.
     *
     * @param dimensionsCar as dimensões do carro
     */
    @Override
    public void buildDimensions ( DimensionsCar dimensionsCar ) {
        ConcreteBuilderDimensionsCar builderDimensionsCar = new ConcreteBuilderDimensionsCar();
        DimensionsCar builtDimensions = DirectorDimensionsCar.construct(
                builderDimensionsCar,
                dimensionsCar.getLength(),
                dimensionsCar.getWidth(),
                dimensionsCar.getHeight(),
                dimensionsCar.getWheelBase()
        );
        car.setDimensions( builtDimensions );
    }

    /**
     * Constrói e retorna o objeto carro com as propriedades especificadas.
     *
     * @return o objeto carro construído
     */
    @Override
    public Cars buildCar () {
        return car;
    }


}
