package org.example.dto;

/**
 * Data Transfer Object (DTO) para registro de um novo usuário.
 * <p>
 * Este registro é utilizado para encapsular as informações necessárias para o registro de um novo
 * usuário na aplicação. Inclui o nome de usuário e a senha do usuário.
 * </p>
 *
 * @param username o nome de usuário do novo usuário
 * @param password a senha do novo usuário
 */
public record RegisterForUserDTO( String username, String email, String password ) {
}
