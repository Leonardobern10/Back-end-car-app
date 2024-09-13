package org.example.validations;

import org.example.model.SpecificationsCar;

/**
 * Classe responsável pela validação das especificações de um carro.
 * <p>
 * Fornece métodos para verificar se as especificações do carro são válidas.
 * As especificações incluem tipo de motor, capacidade do motor, autonomia, aceleração e
 * velocidade máxima.
 * </p>
 */
public class SpecificationsValidate {

    /**
     * Valida as especificações de um carro.
     * <p>
     * Este método verifica se todos os campos das especificações do carro são válidos.
     * Isso inclui tipo de motor, capacidade do motor, autonomia, aceleração e velocidade máxima.
     * Se qualquer um desses campos não for válido, uma exceção será lançada.
     * </p>
     *
     * @param specificationsCar o objeto SpecificationsCar contendo as especificações a serem validadas
     * @throws RuntimeException se algum dos campos de especificações não for válido
     */
    public static void validate ( SpecificationsCar specificationsCar ) {
        StringValidation.validate( specificationsCar.getEngineType(), "FIELD IS NOT VALID" );
        StringValidation.validate( specificationsCar.getTopSpeed(), "FIELD IS NOT VALID" );
        StringValidation.validate( specificationsCar.getAcceleration(), "FIELD IS NOT VALID" );
        StringValidation.validate( specificationsCar.getRange(), "FIELD IS NOT VALID" );
        StringValidation.validate( specificationsCar.getEngineCapacity(), "FIELD IS NOT VALID" );
    }
}
