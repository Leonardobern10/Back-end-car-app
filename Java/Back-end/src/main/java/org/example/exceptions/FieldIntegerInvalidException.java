package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um campo que deveria receber um Integer
 * recebeu um tipo de dado inválido.
 * Extende a classe {@link RuntimeException} para representar erros de tempo de execução
 * que não são recuperáveis.
 */
public class FieldIntegerInvalidException extends RuntimeException {

    /**
     * Constrói uma nova instância da exceção FieldIntegerInvalidException com uma mensagem especificada.
     *
     * @param message a mensagem de erro que será associada a esta exceção
     */
    public FieldIntegerInvalidException(String message) {
        super(message);
    }
}
