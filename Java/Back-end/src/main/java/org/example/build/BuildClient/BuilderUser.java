package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;

/**
 * Interface para construir um objeto {@link User} passo a passo.
 */
public interface BuilderUser {

    /**
     * Define o nome de usuário.
     *
     * @param username o nome de usuário
     */
    void buildUsername ( String username );

    /**
     * Define o e-mail do usuário.
     *
     * @param email o e-mail do usuário
     */
    void buildEmail ( String email );

    /**
     * Define a senha do usuário.
     *
     * @param password a senha do usuário
     */
    void buildPassword ( String password );

    /**
     * Define o papel (role) do usuário.
     *
     * @param role o papel do usuário
     */
    void buildRole ( UserRole role );

    /**
     * Constrói e retorna o objeto usuário com as propriedades especificadas.
     *
     * @return o objeto usuário construído
     */
    User buildUser ();
}
