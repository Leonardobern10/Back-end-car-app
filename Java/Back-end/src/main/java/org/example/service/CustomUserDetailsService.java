package org.example.service;

import org.example.model.User;
import org.example.model.UserRole;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Serviço personalizado para carregar detalhes do usuário e gerenciar a criação de usuários.
 * <p>
 * Esta classe implementa a interface {@link UserDetailsService} para fornecer um método para
 * carregar um usuário com base no nome de usuário, além de permitir a criação de novos usuários
 * com criptografia de senha. Utiliza o repositório {@link UserRepository} para interagir com o banco de dados
 * e o {@link PasswordEncoder} para criptografar as senhas dos usuários.
 * </p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Construtor para injeção de dependências.
     *
     * @param userRepository o repositório para interagir com a entidade {@link User}o codificador de senha para criptografar senhas de usuários
     */
    public CustomUserDetailsService ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    /**
     * Carrega os detalhes do usuário com base no nome de usuário fornecido.
     *
     * @param username o nome de usuário do usuário a ser carregado
     * @return um objeto {@link UserDetails} que contém os detalhes do usuário
     * @throws UsernameNotFoundException se nenhum usuário com o nome de usuário fornecido for encontrado
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
     * Cria um novo usuário e o salva no banco de dados.
     *
     * @param username o nome de usuário do novo usuário
     * @param password a senha do novo usuário
     * @return o objeto {@link User} criado e salvo no banco de dados
     */
    public User createForUser ( String username, String password ) {
        return userRepository.save( ClientBuilder.builder( username, password, UserRole.USER_ROLE ) );
    }

    public User createForAdmin ( String username, String password, UserRole role ) {
        return userRepository.save( ClientBuilder.builder( username, password, role ) );
    }

}
