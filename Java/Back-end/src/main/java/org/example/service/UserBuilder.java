package org.example.service;

import org.example.model.User;
import org.example.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


/**
 * Construtor de usuários responsável por criar instâncias de {@link User} com as informações fornecidas.
 * <p>
 * Esta classe utiliza um {@link PasswordEncoder} para criptografar senhas antes de atribuí-las ao usuário.
 * </p>
 */
@Component
public class UserBuilder {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    /**
     * Construtor para a classe {@link UserBuilder}.
     *
     * @param passwordEncoder o {@link PasswordEncoder} utilizado para criptografar senhas.
     */
    public UserBuilder ( PasswordEncoder passwordEncoder ) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Cria uma nova instância de {@link User} com o nome de usuário, senha e role fornecidos.
     * <p>
     * A senha fornecida é criptografada utilizando o {@link PasswordEncoder} antes de ser definida no usuário.
     * </p>
     *
     * @param username o nome de usuário a ser atribuído ao novo usuário.
     * @param password a senha do novo usuário, que será criptografada.
     * @param role     a role do novo usuário.
     * @return uma instância de {@link User} com os valores fornecidos e a senha criptografada.
     */
    public User builder ( String username, String password, UserRole role ) {
        User user = new User();
        user.setUsername( username );
        user.setPassword( passwordEncoder.encode( password ) );
        user.setRole( role );
        return user;
    }
}
