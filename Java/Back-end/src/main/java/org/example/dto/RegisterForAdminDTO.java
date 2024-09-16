package org.example.dto;

import org.example.role.UserRole;

/**
 * Data Transfer Object (DTO) para o registro de um novo usuário com um papel administrativo.
 * <p>
 * Este DTO é utilizado para encapsular as informações necessárias para o registro de um novo usuário
 * com um papel específico na aplicação, como ADMIN ou USER. Ele inclui o nome de usuário, a senha, o e-mail
 * e o papel do usuário.
 * </p>
 *
 * @param username o nome de usuário do novo usuário
 * @param password a senha do novo usuário
 * @param email    o endereço de e-mail do novo usuário
 * @param role     o papel do novo usuário na aplicação, representado pela enumeração {@link UserRole}
 */
public record RegisterForAdminDTO( String username, String password, String email, UserRole role ) {
}
