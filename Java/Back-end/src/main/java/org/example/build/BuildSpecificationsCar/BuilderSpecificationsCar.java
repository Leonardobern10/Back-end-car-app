package org.example.build.BuildSpecificationsCar;

import org.example.model.SpecificationsCar;

/**
 * Interface para construir um objeto {@link SpecificationsCar} passo a passo.
 */
public interface BuilderSpecificationsCar {

    /**
     * Define o tipo de motor.
     *
     * @param engineType o tipo de motor
     */
    void buildEngineType ( String engineType );

    /**
     * Define a capacidade do motor.
     *
     * @param engineCapacity a capacidade do motor
     */
    void buildEngineCapacity ( String engineCapacity );

    /**
     * Define a autonomia do veículo.
     *
     * @param range a autonomia do veículo
     */
    void buildRange ( String range );

    /**
     * Define a aceleração do veículo.
     *
     * @param acceleration a aceleração do veículo
     */
    void buildAcceleration ( String acceleration );

    /**
     * Define a velocidade máxima do veículo.
     *
     * @param topSpeed a velocidade máxima do veículo
     */
    void buildTopSpeed ( String topSpeed );

    /**
     * Constrói e retorna o objeto especificações do carro com as propriedades especificadas.
     *
     * @return o objeto especificações do carro construído
     */
    SpecificationsCar buildSpecificationsCar ();
}
