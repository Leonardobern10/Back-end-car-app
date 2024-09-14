package org.example.service;

import org.example.events.UserRegisteredEvent;
import org.example.model.User;
import org.example.model.UserRole;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Serviço personalizado para carregar detalhes do usuário e criar novos usuários.
 * <p>
 * Esta classe implementa a interface {@link UserDetailsService} para fornecer a funcionalidade de carregar
 * detalhes do usuário para autenticação. Ela também fornece métodos para criar novos usuários e publicar eventos
 * relacionados ao registro de usuários.
 * </p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private final ClientBuilder clientBuilder;
    private final UserRepository userRepository;

    /**
     * Construtor para a classe {@link CustomUserDetailsService}.
     *
     * @param userRepository o repositório de usuários {@link UserRepository} utilizado para recuperar e salvar usuários.
     * @param clientBuilder  o construtor de usuários {@link ClientBuilder} utilizado para criar novas instâncias de {@link User}.
     */
    @Autowired
    public CustomUserDetailsService ( UserRepository userRepository, ClientBuilder clientBuilder ) {
        this.userRepository = userRepository;
        this.clientBuilder = clientBuilder;
    }

    /**
     * Carrega um usuário específico com base no nome de usuário fornecido.
     * <p>
     * Este método é utilizado pelo Spring Security para recuperar os detalhes do usuário para autenticação.
     * </p>
     *
     * @param username o nome de usuário do usuário a ser carregado.
     * @return uma instância de {@link UserDetails} contendo os detalhes do usuário.
     * @throws UsernameNotFoundException se o usuário com o nome fornecido não for encontrado.
     */
    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        User user = userRepository.findByUsername( username );
        if ( user == null ) {
            throw new UsernameNotFoundException( "USER NOT FOUND" );
        }

        return org.springframework.security.core.userdetails.User
                .withUsername( user.getUsername() )
                .password( user.getPassword() )
                .roles( user.getRole() )
                .build();
    }

    /**
     * Cria um novo usuário com a role padrão de {@link UserRole#USER_ROLE}.
     * <p>
     * Este método utiliza o {@link ClientBuilder} para criar uma nova instância de {@link User} e salva no
     * repositório. Após a criação do usuário, um evento {@link UserRegisteredEvent} é publicado.
     * </p>
     *
     * @param username o nome de usuário do novo usuário.
     * @param password a senha do novo usuário.
     * @return o usuário criado e salvo no banco de dados.
     */
    public User createForUser ( String username, String password ) {
        User user = clientBuilder.builder( username, password, UserRole.USER_ROLE );
        user = userRepository.save( user );
        eventPublisher.publishEvent( new UserRegisteredEvent( user ) );
        return user;
    }

    /**
     * Cria um novo usuário com uma role específica.
     * <p>
     * Este método utiliza o {@link ClientBuilder} para criar uma nova instância de {@link User} com o papel fornecido
     * e salva no repositório.
     * </p>
     *
     * @param username o nome de usuário do novo usuário.
     * @param password a senha do novo usuário.
     * @param role     a role a ser atribuída ao novo usuário.
     * @return o usuário criado e salvo no banco de dados.
     */
    public User createForAdmin ( String username, String password, UserRole role ) {
        User user = clientBuilder.builder( username, password, role );
        return userRepository.save( user );
    }
}
