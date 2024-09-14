package org.example.config;

import org.example.model.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configura a segurança do aplicativo, controlando quem pode acessar quais endpoints.
 * <p>
 * Essa configuração inclui regras para autorização de requisições HTTP, desativação de CSRF para certos endpoints
 * e a habilitação de autenticação básica.
 * </p>
 * <p>
 * A anotação {@link EnableMethodSecurity} permite o uso de anotações de segurança em métodos, como {@code @PreAuthorize}.
 * </p>
 */
@Configuration
@EnableMethodSecurity( prePostEnabled = true )
public class WebSecurityConfig {

    /**
     * Configura as regras de segurança HTTP do aplicativo.
     * <p>
     * Permite que usuários acessem o endpoint {@code /users/create} sem autenticação e desativa a proteção CSRF para ele.
     * Requer autenticação para outros endpoints, com permissões específicas para operações de administração e acesso a dados.
     * </p>
     *
     * @param http o objeto {@link HttpSecurity} que define as configurações de segurança HTTP.
     * @return um {@link SecurityFilterChain} configurado com as regras de segurança.
     * @throws Exception se ocorrer um erro durante a configuração da segurança.
     */
    @Bean
    public SecurityFilterChain securityFilterChain ( HttpSecurity http ) throws Exception {
        http
                .csrf( csrf -> csrf
                        .ignoringRequestMatchers( "/users/create" )// Desativa CSRF para o endpoint específico
                )
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers( HttpMethod.POST, "/users/create" ).permitAll()
                                .requestMatchers( HttpMethod.POST, "/admin/create" )
                                .hasRole( UserRole.ADMIN_ROLE.getRole() )
                                .requestMatchers( HttpMethod.GET, "/cars" )
                                .hasAnyRole( UserRole.USER_ROLE.getRole(), UserRole.ADMIN_ROLE.getRole() )
                                .requestMatchers( HttpMethod.GET, "/cars/**" )
                                .hasAnyRole( UserRole.USER_ROLE.getRole(), UserRole.ADMIN_ROLE.getRole() )
                                .requestMatchers( HttpMethod.POST, "/cars" )
                                .hasRole( UserRole.ADMIN_ROLE.getRole() )
                                .requestMatchers( HttpMethod.PUT, "/cars/**" )
                                .hasRole( UserRole.ADMIN_ROLE.getRole() )
                                .requestMatchers( HttpMethod.DELETE, "/cars/**" )
                                .hasRole( UserRole.ADMIN_ROLE.getRole() )
                                .anyRequest().authenticated()
                )
                .httpBasic( Customizer.withDefaults() );
        return http.build();
    }

    /**
     * Define como as senhas serão codificadas.
     * <p>
     * Utiliza o algoritmo BCrypt para garantir a segurança das senhas armazenadas.
     * </p>
     *
     * @return um {@link PasswordEncoder} que usa o algoritmo BCrypt.
     */
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
