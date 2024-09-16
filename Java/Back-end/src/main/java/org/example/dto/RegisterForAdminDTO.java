package org.example.dto;

import org.example.role.UserRole;

/**
 * Data Transfer Object (DTO) para registro de um novo usuário com um papel administrativo.
 * <p>
 * Este registro é utilizado para encapsular as informações necessárias para o registro de um novo
 * usuário com um papel específico na aplicação. Ele inclui o nome de usuário, a senha e o papel
 * do usuário.
 * </p>
 *
 * @param username o nome de usuário do novo usuário
 * @param password a senha do novo usuário
 * @param role     o papel do novo usuário na aplicação (por exemplo, ADMIN ou USER)
 */
public record RegisterForAdminDTO( String username, String password, String email, UserRole role ) {
}
