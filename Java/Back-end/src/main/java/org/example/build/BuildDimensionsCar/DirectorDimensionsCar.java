package org.example.build.BuildDimensionsCar;

import org.example.model.DimensionsCar;

/**
 * Classe responsável por construir um objeto {@link DimensionsCar} usando um {@link BuilderDimensionsCar}.
 * A construção é feita através da configuração passo a passo do objeto dimensões do carro.
 */
public class DirectorDimensionsCar {

    /**
     * Constrói um objeto {@link DimensionsCar} utilizando o {@link BuilderDimensionsCar} e as propriedades fornecidas.
     *
     * @param builderDimensionsCar o construtor de dimensões do carro que será usado para construir o objeto dimensões do carro
     * @param length               o comprimento do carro
     * @param width                a largura do carro
     * @param height               a altura do carro
     * @param wheelBase            a distância entre eixos do carro
     * @return o objeto dimensões do carro construído
     */
    public static DimensionsCar construct ( BuilderDimensionsCar builderDimensionsCar, String length, String width, String height, String wheelBase ) {
        builderDimensionsCar.buildLength( length );
        builderDimensionsCar.buildWidth( width );
        builderDimensionsCar.buildHeight( height );
        builderDimensionsCar.buildWheelBase( wheelBase );
        return builderDimensionsCar.buildDimensionsCar();
    }
}
