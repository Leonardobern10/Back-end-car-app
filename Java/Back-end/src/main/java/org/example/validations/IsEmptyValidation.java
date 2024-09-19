package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;
import org.example.utils.Errors;

import java.util.List;

/**
 * Classe de validação para verificar se uma lista de carros está vazia.
 */
public class IsEmptyValidation {

    public static void validate ( List<String> list ) {
        if ( list.isEmpty() ) {
            throw new ResourceNotFoundException( Errors.FIELD_ERROR + list );
        }
    }
}
