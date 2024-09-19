package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;

/**
 * Implementação concreta do construtor de usuários, que cria e configura um objeto {@link User}
 * através dos métodos fornecidos na interface {@link BuilderUser}.
 */
public class ConcreteBuilderUser implements BuilderUser {
    User user = null;

    /**
     * Cria uma nova instância de {@link ConcreteBuilderUser} e inicializa o objeto {@link User}.
     */
    public ConcreteBuilderUser () {
        user = new User();
    }

    /**
     * Define o nome de usuário.
     *
     * @param username o nome de usuário
     */
    @Override
    public void buildUsername ( String username ) {
        user.setUsername( username );
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param email o e-mail do usuário
     */
    @Override
    public void buildEmail ( String email ) {
        user.setEmail( email );
    }

    /**
     * Define a senha do usuário.
     *
     * @param password a senha do usuário
     */
    @Override
    public void buildPassword ( String password ) {
        user.setPassword( password );
    }

    /**
     * Define o papel (role) do usuário.
     *
     * @param role o papel do usuário
     */
    @Override
    public void buildRole ( UserRole role ) {
        user.setRole( role );
    }

    /**
     * Constrói e retorna o objeto usuário com as propriedades especificadas.
     *
     * @return o objeto usuário construído
     */
    @Override
    public User buildUser () {
        return user;
    }
}
