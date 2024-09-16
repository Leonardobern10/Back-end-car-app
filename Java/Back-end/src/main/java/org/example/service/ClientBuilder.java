package org.example.service;

import org.example.model.User;
import org.example.model.UserRole;
import org.example.repository.UserRepository;
import org.example.validations.StringValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

/**
 * Serviço responsável pela construção e validação de objetos {@link User}.
 * <p>
 * Esta classe é utilizada para criar e validar instâncias de {@link User} com base nos dados fornecidos.
 * Ela utiliza o {@link UserBuilder} para construir o usuário e o {@link UserRepository} para verificar a existência
 * do nome de usuário no banco de dados. Validações adicionais são realizadas utilizando a classe {@link StringValidation}.
 * </p>
 */
@Component
public class ClientBuilder {

    private final UserBuilder userBuilder;
    private final UserRepository userRepository;

    /**
     * Construtor para a classe {@link ClientBuilder}.
     *
     * @param userBuilder    o construtor de usuários {@link UserBuilder} utilizado para construir a instância de {@link User}.
     * @param userRepository o repositório de usuários {@link UserRepository} utilizado para verificar a existência do nome de usuário.
     */
    @Autowired
    public ClientBuilder ( UserBuilder userBuilder, UserRepository userRepository ) {
        this.userBuilder = userBuilder;
        this.userRepository = userRepository;
    }

    /**
     * Constrói e valida uma nova instância de {@link User} com base nos dados fornecidos.
     * <p>
     * Realiza a validação do nome de usuário e da senha, e verifica se o nome de usuário já existe no banco de dados.
     * Caso o nome de usuário já esteja em uso, é lançada uma exceção {@link BadCredentialsException}.
     * </p>
     *
     * @param username o nome de usuário a ser validado e utilizado para criar o {@link User}.
     * @param password a senha a ser validada e utilizada para criar o {@link User}.
     * @param role     o papel do usuário a ser atribuído ao {@link User}.
     * @return uma instância de {@link User} com os dados fornecidos.
     * @throws BadCredentialsException  se o nome de usuário já existir no banco de dados.
     * @throws IllegalArgumentException se o nome de usuário ou a senha não forem válidos.
     */
    public User builder ( String username, String password, UserRole role ) {
        StringValidation.validate( username, "FIELD USERNAME IS NOT VALID: " + username );
        StringValidation.validatePassword( password,
                "THIS PASSWORD IS INVALID! IT NEEDS: LETTERS, NUMBERS AND SPECIAL CHARACTERS..." );

        if ( userRepository.findByUsername( username ) != null ) {
            throw new BadCredentialsException( "USERNAME INVALID" );
        }

        StringValidation.validate( role.getRole(), "THIS ROLE IS INVALID: " + role.getRole() );

        return userBuilder.builder( username, password, role );
    }
}
