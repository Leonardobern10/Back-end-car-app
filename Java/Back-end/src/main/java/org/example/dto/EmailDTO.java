package org.example.dto;

/**
 * Data Transfer Object (DTO) para representar as informações necessárias para enviar um e-mail.
 * <p>
 * Este DTO encapsula os dados de um e-mail, incluindo o destinatário, o assunto e a mensagem.
 * </p>
 */
public record EmailDTO( String destinatario, String assunto, String message ) {
}
