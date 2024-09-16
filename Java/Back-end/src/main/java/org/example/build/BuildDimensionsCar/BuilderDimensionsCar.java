package org.example.build.BuildDimensionsCar;

import org.example.model.DimensionsCar;

/**
 * Interface para construir um objeto {@link DimensionsCar} passo a passo.
 */
public interface BuilderDimensionsCar {

    /**
     * Define o comprimento do carro.
     *
     * @param length o comprimento do carro
     */
    void buildLength ( String length );

    /**
     * Define a largura do carro.
     *
     * @param width a largura do carro
     */
    void buildWidth ( String width );

    /**
     * Define a altura do carro.
     *
     * @param height a altura do carro
     */
    void buildHeight ( String height );

    /**
     * Define a distância entre eixos do carro.
     *
     * @param wheelBase a distância entre eixos do carro
     */
    void buildWheelBase ( String wheelBase );

    /**
     * Constrói e retorna o objeto dimensões do carro com as propriedades especificadas.
     *
     * @return o objeto dimensões do carro construído
     */
    DimensionsCar buildDimensionsCar ();
}
