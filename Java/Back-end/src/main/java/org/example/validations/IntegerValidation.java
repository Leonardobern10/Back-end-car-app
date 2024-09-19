package org.example.validations;

import org.example.exceptions.FieldDoubleInvalidException;
import org.example.utils.Errors;

/**
 * Classe de validação para valores inteiros relacionados a carros.
 * <p>
 * Fornece métodos para validar valores inteiros que são usados em contextos relacionados a carros,
 * garantindo que esses valores atendam a requisitos específicos, como não serem negativos.
 * </p>
 */
public class IntegerValidation {

    /**
     * Valida um valor inteiro para garantir que seja não negativo.
     * <p>
     * Este método verifica se o valor fornecido é menor que zero. Se o valor for negativo,
     * uma exceção {@link FieldDoubleInvalidException} é lançada com uma mensagem indicando que o
     * campo é inválido. Caso contrário, o método retorna sem lançar exceções, indicando que o valor
     * é válido.
     * </p>
     *
     * @param carValue o valor inteiro a ser validado
     * @throws FieldDoubleInvalidException se o valor inteiro for negativo
     */
    public static void validate ( Integer carValue ) {
        if ( carValue < 0 ) {
            throw new FieldDoubleInvalidException( Errors.FIELD_ERROR + carValue );
        }
    }
}
