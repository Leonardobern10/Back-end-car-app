package org.example.validations;

import org.example.exceptions.FieldStringInvalidException;

/**
 * Classe responsável pela validação do modelo de um carro.
 * Fornece um método estático para verificar se o modelo é válido.
 */
public class CarModelValidation {

    /**
     * Valida o modelo de um carro.
     * Verifica se o modelo é não nulo e não está em branco. Se for nulo ou estiver em branco,
     * lança uma exceção.
     *
     * @param field o modelo do carro a ser validado
     * @throws FieldStringInvalidException se o modelo fornecido for nulo ou estiver em branco
     */
    public static void validate (String field) {
        if (field == null || field.isBlank())
            throw new FieldStringInvalidException("FIELD MODEL IS INVALID!");
    }
}
