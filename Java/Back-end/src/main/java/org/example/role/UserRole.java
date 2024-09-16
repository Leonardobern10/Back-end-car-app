package org.example.role;

/**
 * Enumeração que define os papéis de usuário na aplicação.
 * <p>
 * Esta enumeração é utilizada para representar os diferentes papéis que um usuário pode ter,
 * incluindo papel de usuário padrão e papel de administrador. Cada papel é associado a um
 * valor de string que pode ser utilizado em outras partes da aplicação para controle de acesso.
 * </p>
 */
public enum UserRole {

    /**
     * Papel de usuário padrão.
     * Representa um usuário com permissões básicas.
     */
    USER_ROLE( "user" ),

    /**
     * Papel de administrador.
     * Representa um usuário com permissões administrativas.
     */
    ADMIN_ROLE( "admin" );

    private final String role;

    /**
     * Constrói uma instância do {@code UserRole} com o valor especificado.
     *
     * @param role o valor da string que representa o papel do usuário
     */
    UserRole ( String role ) {
        this.role = role;
    }

    /**
     * Obtém o valor da string que representa o papel do usuário.
     *
     * @return o valor da string do papel do usuário
     */
    public String getRole () {
        return role;
    }

}
