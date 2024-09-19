package org.example.exceptions;

/**
 * Exceção lançada quando um campo possui um valor inválido.
 * <p>
 * Esta exceção é utilizada para indicar que um campo de um objeto possui um valor que não atende
 * aos critérios de validação esperados. Pode ser lançada em casos de validação de dados em diferentes
 * partes do sistema.
 * </p>
 */
public class InvalidFieldException extends RuntimeException {

    /**
     * Construtor da exceção {@code InvalidFieldException}.
     * <p>
     * Cria uma instância da exceção com a mensagem especificada.
     * </p>
     *
     * @param message a mensagem de erro detalhando o motivo da exceção
     */
    public InvalidFieldException ( String message ) {
        super( message );
    }

    /**
     * Construtor da exceção {@code InvalidFieldException}.
     * <p>
     * Cria uma instância da exceção com a mensagem especificada e a causa da exceção.
     * </p>
     *
     * @param message a mensagem de erro detalhando o motivo da exceção
     * @param cause   a causa que gerou a exceção, podendo ser outra exceção
     */
    public InvalidFieldException ( String message, Throwable cause ) {
        super( message, cause );
    }
}
