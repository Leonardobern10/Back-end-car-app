package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um registro de carro já existe.
 * Extende a classe {@link RuntimeException} para representar erros de tempo de execução
 * que não são recuperáveis.
 */
public class DuplicatedFoundException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção DuplicatedFoundException com uma mensagem especificada.
     *
     * @param message a mensagem de erro que será associada a esta exceção
     */
    public DuplicatedFoundException (String message) {
        super(message);
    }
}
