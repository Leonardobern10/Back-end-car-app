package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um campo que deveria receber um valor do tipo {@code String}
 * recebeu um conteúdo inválido.
 * <p>
 * Essa exceção é lançada quando há uma tentativa de converter ou processar um valor que deveria ser do
 * tipo {@code String}, mas o conteúdo fornecido não atende aos critérios esperados. Extende a classe
 * {@link RuntimeException} para representar erros de tempo de execução que não são recuperáveis.
 * </p>
 */
public class FieldStringInvalidException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção {@code FieldStringInvalidException} com uma mensagem especificada.
     * <p>
     * A mensagem deve descrever a razão pela qual o campo é considerado inválido, fornecendo detalhes sobre
     * o erro específico ocorrido durante a manipulação do valor do campo.
     * </p>
     *
     * @param message a mensagem de erro que será associada a esta exceção
     * @see RuntimeException
     */
    public FieldStringInvalidException ( String message ) {
        super( message );
    }
}
