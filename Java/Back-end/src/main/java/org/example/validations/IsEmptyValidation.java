package org.example.validations;

import org.example.exceptions.ResourceNotFoundException;
import org.example.model.Cars;

import java.util.List;

/**
 * Classe de validação para verificar se uma lista de carros está vazia.
 */
public class IsEmptyValidation {

    /**
     * Valida se a lista de carros está vazia e lança uma exceção se estiver.
     *
     * @param list  a lista de carros a ser verificada.
     * @param param o parâmetro que será incluído na mensagem de exceção se a lista estiver vazia.
     * @throws ResourceNotFoundException se a lista estiver vazia.
     */
    public static void validate ( List<Cars> list, String param ) {
        if ( list.isEmpty() ) {
            String message = String.format( "RESOURCE NOT FOUD FOR %s", param );
            throw new ResourceNotFoundException( message + " " + param );
        }
    }

    /**
     * Valida se a lista de carros está vazia e lança uma exceção se estiver.
     *
     * @param list  a lista de carros a ser verificada.
     * @param param o parâmetro que será incluído na mensagem de exceção se a lista estiver vazia.
     * @throws ResourceNotFoundException se a lista estiver vazia.
     */
    public static void validate ( List<Cars> list, Double param ) {
        if ( list.isEmpty() ) {
            String message = String.format( "RESOURCE NOT FOUD FOR %s", param.toString() );
            throw new ResourceNotFoundException( message + " " + param );
        }
    }

    /**
     * Valida se a lista de carros está vazia e lança uma exceção se estiver.
     *
     * @param list  a lista de carros a ser verificada.
     * @param param o parâmetro que será incluído na mensagem de exceção se a lista estiver vazia.
     * @throws ResourceNotFoundException se a lista estiver vazia.
     */
    public static void validate ( List<Cars> list, Integer param ) {
        if ( list.isEmpty() ) {
            String message = String.format( "RESOURCE NOT FOUD FOR %s", param.toString() );
            throw new ResourceNotFoundException( message + " " + param );
        }
    }

    public static void validate ( List<String> list ) {
        if ( list.isEmpty() ) {
            throw new ResourceNotFoundException( "FIELD IS NOT VALID" );
        }
    }
}
