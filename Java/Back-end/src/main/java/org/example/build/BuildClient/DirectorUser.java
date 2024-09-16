package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por construir um objeto {@link User} usando um {@link BuilderUser}.
 * A construção é feita através da configuração passo a passo do objeto usuário, incluindo a codificação da senha.
 */
@Component
public class DirectorUser {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Constrói um objeto {@link User} utilizando o {@link BuilderUser} e as propriedades fornecidas.
     * A senha é codificada antes de ser definida no usuário.
     *
     * @param builderUser o construtor de usuário que será usado para construir o objeto usuário
     * @param username    o nome de usuário
     * @param email       o e-mail do usuário
     * @param password    a senha do usuário, que será codificada antes de ser definida
     * @param role        o papel do usuário
     * @return o objeto usuário construído
     */
    public User construct ( BuilderUser builderUser, String username, String email, String password, UserRole role ) {
        builderUser.buildUsername( username );
        builderUser.buildEmail( email );
        builderUser.buildPassword( passwordEncoder.encode( password ) );
        builderUser.buildRole( role );
        return builderUser.buildUser();
    }
}
