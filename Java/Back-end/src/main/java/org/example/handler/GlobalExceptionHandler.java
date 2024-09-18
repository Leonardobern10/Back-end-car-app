package org.example.handler;

import org.example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe de tratamento global de exceções para a aplicação.
 * <p>
 * Utiliza a anotação {@link ControllerAdvice} para capturar e manipular exceções lançadas pelos controladores.
 * Esta classe define métodos para tratar diferentes tipos de exceções e retornar respostas apropriadas com status HTTP.
 * </p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manipula exceções do tipo {@link FieldIntegerInvalidException}.
     * <p>
     * Quando uma {@code FieldIntegerInvalidException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 400 (Bad Request) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code FieldIntegerInvalidException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldIntegerInvalidException.class )
    public ResponseEntity<String> handleFieldIntegerInvalid ( FieldIntegerInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link ResourceNotFoundException}.
     * <p>
     * Quando uma {@code ResourceNotFoundException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 404 (Not Found) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code ResourceNotFoundException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 404 (Not Found)
     */
    @ExceptionHandler( ResourceNotFoundException.class )
    public ResponseEntity<String> handleResourceNotFoundException ( ResourceNotFoundException exception ) {
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link BadCredentialsException}.
     * <p>
     * Quando uma {@code BadCredentialsException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 400 (Bad Request) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code BadCredentialsException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( BadCredentialsException.class )
    public ResponseEntity<String> handleBadCredentialsException ( BadCredentialsException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções genéricas não tratadas.
     * <p>
     * Quando uma exceção não tratada é lançada, este método captura a exceção e retorna uma resposta com o status
     * HTTP 500 (Internal Server Error) e uma mensagem genérica de erro com detalhes da exceção.
     * </p>
     *
     * @param exception a exceção genérica que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 500 (Internal Server Error)
     */
    @ExceptionHandler( Exception.class )
    public ResponseEntity<String> handleGlobalException ( Exception exception ) {
        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( "An unexpected error occurred: " + exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link FieldStringInvalidException}.
     * <p>
     * Quando uma {@code FieldStringInvalidException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 400 (Bad Request) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code FieldStringInvalidException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldStringInvalidException.class )
    public ResponseEntity<String> handleFieldStringInvalid ( FieldStringInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link FieldDoubleInvalidException}.
     * <p>
     * Quando uma {@code FieldDoubleInvalidException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 400 (Bad Request) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code FieldDoubleInvalidException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldDoubleInvalidException.class )
    public ResponseEntity<String> handleFieldDoubleInvalid ( FieldDoubleInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link DuplicatedFoundException}.
     * <p>
     * Quando uma {@code DuplicatedFoundException} é lançada, este método captura a exceção e retorna uma
     * resposta com o status HTTP 409 (Conflict) e a mensagem de erro associada à exceção.
     * </p>
     *
     * @param exception a exceção do tipo {@code DuplicatedFoundException} que foi lançada
     * @return {@code ResponseEntity<String>} contendo uma mensagem de erro e o status HTTP 409 (Conflict)
     */
    @ExceptionHandler( DuplicatedFoundException.class )
    public ResponseEntity<String> handleDuplicatedFound ( DuplicatedFoundException exception ) {
        return ResponseEntity.status( HttpStatus.CONFLICT ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo {@link InvalidFieldException}.
     * <p>
     * Este método é responsável por capturar exceções do tipo {@code InvalidFieldException}
     * lançadas na aplicação. Ele retorna uma resposta personalizada com a mensagem de erro
     * associada à exceção, além de um código de status HTTP 400 (Bad Request).
     * </p>
     *
     * @param ex a exceção {@code InvalidFieldException} que foi lançada
     * @return uma resposta HTTP contendo a mensagem de erro da exceção e o código de status 400
     */
    @ExceptionHandler( InvalidFieldException.class )
    public ResponseEntity<String> handleValidationException ( InvalidFieldException ex ) {
        // Retorna uma resposta personalizada com a mensagem de erro
        return new ResponseEntity<>( ex.getMessage(), HttpStatus.BAD_REQUEST );
    }
}
