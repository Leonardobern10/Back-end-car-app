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
        isValid( specificationsCar.getEngineType() );
        isValid( specificationsCar.getEngineCapacity() );
        isValid( specificationsCar.getRange() );
        isValid( specificationsCar.getAcceleration() );
        isValid( specificationsCar.getTopSpeed() );
    }

    // D   R   Y

    /**
     * Verifica se uma especificação fornecida é válida.
     * <p>
     * Este método realiza a validação de uma especificação, que deve ser uma string válida.
     * Se a especificação não for válida, uma exceção será lançada.
     * </p>
     *
     * @param string a especificação a ser verificada
     * @throws RuntimeException se a especificação fornecida não for válida
     */
    private static void isValid ( String string ) {
        CarStringValidation.validate( string, "FIELD IS NOT VALID: " + string );
    }
}
