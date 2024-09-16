package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Classe de validação para verificar se uma lista de carros está vazia.
 */
public class IsEmptyValidation {

    public static void validate ( List<String> list ) {
        if ( list.isEmpty() ) {
            throw new ResourceNotFoundException( "FIELD features IS NOT VALID" );
        }
    }
}
