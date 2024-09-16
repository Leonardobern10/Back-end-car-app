package org.example.build.BuildSpecificationsCar;

import org.example.model.SpecificationsCar;

/**
 * Classe responsável por construir um objeto {@link SpecificationsCar} usando um {@link BuilderSpecificationsCar}.
 * A construção é feita através da configuração passo a passo do objeto especificações do carro.
 */
public class DirectorSpecificationsCar {

    /**
     * Constrói um objeto {@link SpecificationsCar} utilizando o {@link BuilderSpecificationsCar} e as propriedades fornecidas.
     *
     * @param builderSpecificationsCar o construtor de especificações do carro que será usado para construir o objeto especificações do carro
     * @param engineType               o tipo de motor
     * @param engineCapacity           a capacidade do motor
     * @param range                    a autonomia do veículo
     * @param acceleration             a aceleração do veículo
     * @param topSpeed                 a velocidade máxima do veículo
     * @return o objeto especificações do carro construído
     */
    public static SpecificationsCar construct ( BuilderSpecificationsCar builderSpecificationsCar, String engineType, String engineCapacity, String range, String acceleration, String topSpeed ) {
        builderSpecificationsCar.buildEngineType( engineType );
        builderSpecificationsCar.buildEngineCapacity( engineCapacity );
        builderSpecificationsCar.buildRange( range );
        builderSpecificationsCar.buildAcceleration( acceleration );
        builderSpecificationsCar.buildTopSpeed( topSpeed );
        return builderSpecificationsCar.buildSpecificationsCar();
    }
}
