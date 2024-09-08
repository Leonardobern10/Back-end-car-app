package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um recurso não foi encontrado.
 * Extende a classe {@link RuntimeException} para representar erros de tempo de execução
 * que não são recuperáveis.
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção ResourceNotFoundException com uma mensagem especificada.
     *
     * @param message a mensagem de erro que será associada a esta exceção
     */
    public ResourceNotFoundException (String message) {
        super(message);
    }
}
