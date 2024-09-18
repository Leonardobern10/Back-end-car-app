package org.example.validations;

import org.example.exceptions.FieldDoubleInvalidException;

/**
 * Classe responsável pela validação do valor de um carro.
 * Fornece um método estático para verificar se o valor é válido.
 */
public class CarValueValidation {

    /**
     * Valida o valor de um carro.
     * Verifica se o valor é finito, não é NaN e não é negativo. Se o valor for infinito,
     * NaN ou negativo, lança uma exceção.
     *
     * @param carValue o valor do carro a ser validado
     * @throws FieldDoubleInvalidException se o valor fornecido for infinito, NaN ou negativo
     */
    public static void validate ( double carValue ) {
        if ( Double.isInfinite( carValue ) || Double.isNaN( carValue ) || carValue < 0 )
            throw new FieldDoubleInvalidException( "FIELD CAR_VALUE IS INVALID" );
    }
}
