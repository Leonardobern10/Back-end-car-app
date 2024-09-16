package org.example.dto;

/**
 * Data Transfer Object (DTO) para o registro de um novo usuário.
 * <p>
 * Este DTO é utilizado para encapsular as informações necessárias para o registro de um novo usuário na aplicação.
 * Ele inclui o nome de usuário, o endereço de e-mail e a senha do usuário.
 * </p>
 *
 * @param username o nome de usuário do novo usuário
 * @param email    o endereço de e-mail do novo usuário
 * @param password a senha do novo usuário
 */
public record RegisterForUserDTO( String username, String email, String password ) {
}
