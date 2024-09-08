package org.example.validations;

import org.example.exceptions.FieldStringInvalidException;

/**
 * Classe responsável pela validação da URL de um carro.
 * Fornece um método estático para verificar se a URL é válida.
 */
public class CarUrlValidation {
    /**
     * Valida a URL de um carro.
     * Verifica se a URL não está em branco ou vazia. Se a URL estiver em branco ou vazia,
     * lança uma exceção.
     *
     * @param url a URL do carro a ser validada
     * @throws FieldStringInvalidException se a URL fornecida estiver em branco ou vazia
     */
    public static void validate (String url) {
        if (url.isBlank() || url.isEmpty())
            throw new FieldStringInvalidException("FIELD URL IS INVALID");
    }
}
