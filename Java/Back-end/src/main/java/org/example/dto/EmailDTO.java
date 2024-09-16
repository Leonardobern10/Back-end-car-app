package org.example.dto;

/**
 * Data Transfer Object (DTO) para representar as informações necessárias para enviar um e-mail.
 * <p>
 * Este DTO encapsula os dados de um e-mail, incluindo o destinatário, o assunto e a mensagem.
 * </p>
 */
public record EmailDTO(
        /**
         * Endereço de e-mail do destinatário.
         * <p>
         * Este campo armazena o endereço de e-mail para o qual a mensagem deve ser enviada.
         * </p>
         */
        String destinatario,

        /**
         * Assunto do e-mail.
         * <p>
         * Este campo armazena o assunto do e-mail que será enviado.
         * </p>
         */
        String assunto,

        /**
         * Corpo da mensagem do e-mail.
         * <p>
         * Este campo armazena o conteúdo textual do e-mail.
         * </p>
         */
        String message
) {
}
