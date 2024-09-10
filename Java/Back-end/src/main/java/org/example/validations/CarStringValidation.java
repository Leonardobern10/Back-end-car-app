package org.example.validations;

import org.example.exceptions.FieldStringInvalidException;
import org.springframework.stereotype.Component;

/**
 * Classe responsável pela validação de campos do tipo String.
 * Fornece um método estático para verificar se uma String é válida.
 */
@Component
public class CarStringValidation {

    /**
     * Valida se a String fornecida não está vazia e não é nula.
     * Se a String for nula ou vazia, lança uma exceção com a mensagem de erro fornecida.
     *
     * @param string a String a ser validada
     * @param messageError a mensagem de erro a ser lançada em caso de falha na validação
     * @throws FieldStringInvalidException se a String for nula ou vazia
     */
    public static void validate(String string, String messageError) throws FieldStringInvalidException {
        if (string.isBlank() || string == null) {
            throw new FieldStringInvalidException(messageError);
        }
    }
}
