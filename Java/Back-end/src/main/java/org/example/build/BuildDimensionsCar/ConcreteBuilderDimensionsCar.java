package org.example.build.BuildDimensionsCar;

import org.example.model.DimensionsCar;

/**
 * Implementação concreta do construtor de dimensões do carro, que cria e configura um objeto {@link DimensionsCar}
 * através dos métodos fornecidos na interface {@link BuilderDimensionsCar}.
 */
public class ConcreteBuilderDimensionsCar implements BuilderDimensionsCar {

    DimensionsCar dimensionsCar;

    /**
     * Cria uma nova instância de {@link ConcreteBuilderDimensionsCar} e inicializa o objeto {@link DimensionsCar}.
     */
    public ConcreteBuilderDimensionsCar () {
        dimensionsCar = new DimensionsCar();
    }

    /**
     * Define o comprimento do carro.
     *
     * @param length o comprimento do carro
     */
    @Override
    public void buildLength ( String length ) {
        dimensionsCar.setLength( length );
    }

    /**
     * Define a largura do carro.
     *
     * @param width a largura do carro
     */
    @Override
    public void buildWidth ( String width ) {
        dimensionsCar.setWidth( width );
    }

    /**
     * Define a altura do carro.
     *
     * @param height a altura do carro
     */
    @Override
    public void buildHeight ( String height ) {
        dimensionsCar.setHeight( height );
    }

    /**
     * Define a distância entre eixos do carro.
     *
     * @param wheelBase a distância entre eixos do carro
     */
    @Override
    public void buildWheelBase ( String wheelBase ) {
        dimensionsCar.setWheelBase( wheelBase );
    }

    /**
     * Constrói e retorna o objeto dimensões do carro com as propriedades especificadas.
     *
     * @return o objeto dimensões do carro construído
     */
    @Override
    public DimensionsCar buildDimensionsCar () {
        return dimensionsCar;
    }
}
