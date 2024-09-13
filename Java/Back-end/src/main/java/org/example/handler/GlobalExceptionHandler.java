package org.example.handler;

import org.example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe de tratamento global de exceções para a aplicação.
 * Utiliza a anotação @ControllerAdvice para capturar e manipular exceções lançadas pelos controladores.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Manipula exceções do tipo FieldIntegerInvalidException.
     *
     * @param exception a exceção do tipo FieldIntegerInvalidException que foi lançada
     * @return ResponseEntity contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldIntegerInvalidException.class )
    public ResponseEntity<String> handleFieldIntegerInvalid ( FieldIntegerInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo ResourceNotFoundException.
     *
     * @param exception a exceção do tipo ResourceNotFoundException que foi lançada
     * @return ResponseEntity contendo uma mensagem de erro e o status HTTP 404 (Not Found)
     */
    @ExceptionHandler( ResourceNotFoundException.class )
    public ResponseEntity<String> handleResourceNotFoundException ( ResourceNotFoundException exception ) {
        return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( exception.getMessage() );
    }

    @ExceptionHandler( BadCredentialsException.class )
    public ResponseEntity<String> handleBadCredentialsException ( BadCredentialsException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    @ExceptionHandler( Exception.class )
    public ResponseEntity<String> handleGlobalException ( Exception exception ) {
        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( "An unexpected error occurred: " + exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo FieldStringInvalidException.
     *
     * @param exception a exceção do tipo FieldStringInvalidException que foi lançada
     * @return ResponseEntity contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldStringInvalidException.class )
    public ResponseEntity<String> handleFieldStringInvalid ( FieldStringInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo FieldDoubleInvalidException.
     *
     * @param exception a exceção do tipo FieldDoubleInvalidException que foi lançada
     * @return ResponseEntity contendo uma mensagem de erro e o status HTTP 400 (Bad Request)
     */
    @ExceptionHandler( FieldDoubleInvalidException.class )
    public ResponseEntity<String> handleFieldDoubleInvalid ( FieldDoubleInvalidException exception ) {
        return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( exception.getMessage() );
    }

    /**
     * Manipula exceções do tipo DuplicatedFoundException.
     *
     * @param exception a exceção do tipo DuplicatedFoundException que foi lançada
     * @return ResponseEntity contendo uma mensagem de erro e o status HTTP 409 (Conflict)
     */
    @ExceptionHandler( DuplicatedFoundException.class )
    public ResponseEntity<String> handleDuplicatedFound ( DuplicatedFoundException exception ) {
        return ResponseEntity.status( HttpStatus.CONFLICT ).body( exception.getMessage() );
    }

}
