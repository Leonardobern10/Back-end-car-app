package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um campo que deveria receber um String
 * recebeu um tipo de dado inválido.
 * Extende a classe {@link RuntimeException} para representar erros de tempo de execução
 * que não são recuperáveis.
 */
public class FieldStringInvalidException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção FieldStringInvalidException com uma mensagem especificada.
     *
     * @param message a mensagem de erro que será associada a esta exceção
     */
    public FieldStringInvalidException(String message) {
        super(message);
    }
}
