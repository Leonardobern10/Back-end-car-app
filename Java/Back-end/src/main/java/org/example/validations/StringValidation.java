package org.example.validations;

import org.example.exceptions.FieldStringInvalidException;
import org.example.utils.Errors;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Classe responsável pela validação de campos do tipo String.
 * Fornece um método estático para verificar se uma String é válida.
 */
@Component
public class StringValidation {

    private static final String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    /**
     * Valida se a senha fornecida atende aos critérios de complexidade definidos pelo padrão regex.
     * <p>
     * A senha deve ter pelo menos 8 caracteres e incluir pelo menos uma letra minúscula, uma letra maiúscula,
     * um dígito e um caractere especial (@, $, !, %, *, ?, &).
     * </p>
     *
     * @param password     a senha a ser validada
     * @param messageError a mensagem de erro a ser lançada se a validação falhar
     * @throws BadCredentialsException se a senha não atender aos critérios de complexidade definidos
     */
    public static void validatePassword ( String password, String messageError ) {
        if ( ! (Pattern.matches( REGEX, password ) || password != null) ) {
            throw new BadCredentialsException( messageError );
        }
    }

    /**
     * Valida se a String fornecida não está vazia e não é nula.
     * Se a String for nula ou vazia, lança uma exceção com a mensagem de erro fornecida.
     *
     * @param string       a String a ser validada
     * @param messageError a mensagem de erro a ser lançada em caso de falha na validação
     * @throws FieldStringInvalidException se a String for nula ou vazia
     */

    public static void validate ( String... strings ) {
        for ( String string : strings ) {
            String messageError = Errors.FIELD_ERROR + string;
            isValid( string, messageError );
        }
    }

    private static void isValid ( String string, String messageError ) {
        if ( string == null || string.isBlank() ) {
            throw new FieldStringInvalidException( messageError );
        }
    }
}
