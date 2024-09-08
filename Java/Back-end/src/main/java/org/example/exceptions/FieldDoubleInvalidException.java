package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um campo que deveria receber um
 * Double recebeu um conteudo inválido.
 * Extende a classe {@link RuntimeException} para representar erros de tempo de execução
 * que não são recuperáveis.
 */
public class FieldDoubleInvalidException extends RuntimeException {

    /**
     * Constrói uma nova instância da exceção FieldDoubleInvalidException com uma mensagem especificada.
     *
     * @param message a mensagem de erro que será associada a esta exceção
     */
    public FieldDoubleInvalidException(String message) {
        super(message);
    }
}
