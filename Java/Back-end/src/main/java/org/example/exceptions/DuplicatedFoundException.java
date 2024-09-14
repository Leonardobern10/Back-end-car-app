package org.example.exceptions;

/**
 * Exceção personalizada para indicar que um registro duplicado foi encontrado.
 * <p>
 * Essa exceção é lançada quando uma tentativa de criar ou adicionar um registro
 * resulta em um conflito devido à presença de um registro existente com os mesmos
 * dados. Extende a classe {@link RuntimeException}, representando erros em tempo
 * de execução que normalmente não podem ser recuperados.
 * </p>
 */
public class DuplicatedFoundException extends RuntimeException {
    /**
     * Constrói uma nova instância da exceção DuplicatedFoundException com uma mensagem especificada.
     * <p>
     * A mensagem deve descrever o motivo pelo qual a exceção foi lançada,
     * fornecendo detalhes sobre o conflito detectado.
     * </p>
     *
     * @param message a mensagem de erro que será associada a esta exceção
     * @see RuntimeException
     */
    public DuplicatedFoundException ( String message ) {
        super( message );
    }
}
