package org.example.handler;

import org.example.build.BuildClient.ConcreteBuilderUser;
import org.example.build.BuildClient.DirectorUser;
import org.example.model.User;
import org.example.role.UserRole;
import org.example.repository.UserRepository;
import org.example.utils.Errors;
import org.example.validations.StringValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

/**
 * Serviço responsável pela construção e validação de objetos {@link User}.
 * <p>
 * Esta classe é utilizada para criar e validar instâncias de {@link User} com base nos dados fornecidos.
 * Ela utiliza o {@link DirectorUser} para construir o usuário e o {@link UserRepository} para verificar a existência
 * do nome de usuário no banco de dados. Validações adicionais são realizadas utilizando a classe {@link StringValidation}.
 * </p>
 */
@Component
public class HandleClient {

    private final UserRepository userRepository;
    private final DirectorUser directorUser;

    /**
     * Construtor para a classe {@link HandleClient}.
     * <p>
     * Injeta o {@link UserRepository} e o {@link DirectorUser} necessários para a validação e construção do usuário.
     * </p>
     *
     * @param userRepository o repositório de usuários {@link UserRepository} utilizado para verificar a existência do nome de usuário
     * @param directorUser   o {@link DirectorUser} utilizado para construir o usuário
     */
    @Autowired
    public HandleClient ( UserRepository userRepository, DirectorUser directorUser ) {
        this.userRepository = userRepository;
        this.directorUser = directorUser;
    }

    /**
     * Constrói e valida uma nova instância de {@link User} com base nos dados fornecidos.
     * <p>
     * Realiza a validação do nome de usuário, e-mail e senha, e verifica se o nome de usuário já existe no banco de dados.
     * Caso o nome de usuário já esteja em uso, é lançada uma exceção {@link BadCredentialsException}.
     * </p>
     *
     * @param username o nome de usuário a ser validado e utilizado para criar o {@link User}
     * @param email    o endereço de e-mail a ser validado e utilizado para criar o {@link User}
     * @param password a senha a ser validada e utilizada para criar o {@link User}
     * @param role     o papel do usuário a ser atribuído ao {@link User}
     * @return uma instância de {@link User} com os dados fornecidos
     * @throws BadCredentialsException  se o nome de usuário já existir no banco de dados
     * @throws IllegalArgumentException se o nome de usuário, e-mail ou a senha não forem válidos
     */
    public User toCallBuilder ( String username, String email, String password, UserRole role ) {
        StringValidation.validate( username, password, email );
        StringValidation.validatePassword( password, Errors.PASSWORD_INVALID_ERROR );

        if ( userRepository.findByUsername( username ) != null ) {
            throw new BadCredentialsException( "USERNAME INVALID" );
        }

        StringValidation.validate( role.getRole() );

        ConcreteBuilderUser builderUser = new ConcreteBuilderUser();
        return directorUser.construct( builderUser, username, email, password, role );
    }
}
