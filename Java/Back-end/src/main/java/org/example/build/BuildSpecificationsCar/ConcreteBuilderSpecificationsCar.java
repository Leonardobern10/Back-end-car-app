package org.example.build.BuildSpecificationsCar;

import org.example.model.SpecificationsCar;

/**
 * Implementação concreta do construtor de especificações do carro, que cria e configura um objeto {@link SpecificationsCar}
 * através dos métodos fornecidos na interface {@link BuilderSpecificationsCar}.
 */
public class ConcreteBuilderSpecificationsCar implements BuilderSpecificationsCar {
    SpecificationsCar specificationsCar = null;


    /**
     * Cria uma nova instância de {@link ConcreteBuilderSpecificationsCar} e inicializa o objeto {@link SpecificationsCar}.
     */
    public ConcreteBuilderSpecificationsCar () {
        specificationsCar = new SpecificationsCar();
    }

    /**
     * Define o tipo de motor.
     *
     * @param engineType o tipo de motor
     */
    @Override
    public void buildEngineType ( String engineType ) {
        specificationsCar.setEngineType( engineType );
    }

    /**
     * Define a capacidade do motor.
     *
     * @param engineCapacity a capacidade do motor
     */
    @Override
    public void buildEngineCapacity ( String engineCapacity ) {
        specificationsCar.setEngineCapacity( engineCapacity );
    }


    /**
     * Define a autonomia do veículo.
     *
     * @param range a autonomia do veículo
     */
    @Override
    public void buildRange ( String range ) {
        specificationsCar.setRange( range );
    }


    /**
     * Define a aceleração do veículo.
     *
     * @param acceleration a aceleração do veículo
     */
    @Override
    public void buildAcceleration ( String acceleration ) {
        specificationsCar.setAcceleration( acceleration );
    }

    /**
     * Define a velocidade máxima do veículo.
     *
     * @param topSpeed a velocidade máxima do veículo
     */
    public void buildTopSpeed ( String topSpeed ) {
        specificationsCar.setTopSpeed( topSpeed );
    }

    /**
     * Constrói e retorna o objeto especificações do carro com as propriedades especificadas.
     *
     * @return o objeto especificações do carro construído
     */
    @Override
    public SpecificationsCar buildSpecificationsCar () {
        return specificationsCar;
    }
}
