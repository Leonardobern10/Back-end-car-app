package org.example.validations;

import org.example.exceptions.FieldIntegerInvalidException;


/**
 * Classe responsável pela validação do ID de um carro.
 * Fornece um método estático para verificar se o ID é válido.
 */
public class CarIdValidation {

    /**
     * Valida o ID de um carro.
     * Verifica se o ID é um número não negativo. Se o ID for negativo, lança uma exceção.
     *
     * @param id o ID do carro a ser validado
     * @throws FieldIntegerInvalidException se o ID fornecido for negativo
     */
    public static void validate(int id) {
        if (id < 0)
            throw new FieldIntegerInvalidException("ID INVÁLIDO!");
    }
}
