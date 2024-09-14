package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um recurso não foi encontrado.
 * <p>
 * Esta exceção é lançada quando uma tentativa de acessar um recurso que não existe ou não foi encontrado no
 * sistema é feita. Extende a classe {@link RuntimeException} para representar erros de tempo de execução que
 * não são recuperáveis.
 * </p>
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção {@code ResourceNotFoundException} com uma mensagem especificada.
     * <p>
     * A mensagem deve descrever o recurso que não foi encontrado e fornecer detalhes adicionais sobre o
     * contexto do erro. Esta mensagem será associada a esta exceção e pode ser usada para fornecer informações
     * úteis para a depuração ou para o usuário final.
     * </p>
     *
     * @param message a mensagem de erro que será associada a esta exceção
     * @see RuntimeException
     */
    public ResourceNotFoundException ( String message ) {
        super( message );
    }
}
