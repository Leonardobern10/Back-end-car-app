package org.example.config;

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
 * Classe de configuração responsável pela configuração de segurança do aplicativo.
 * Esta classe define as regras de segurança HTTP para o aplicativo usando Spring Security.
 * <p>
 * A configuração inclui a configuração de CSRF (Cross-Site Request Forgery), autorização de requisições HTTP e
 * a configuração de autenticação básica HTTP. Além disso, fornece um {@link PasswordEncoder} para a codificação de senhas.
 * </p>
 * <p>
 * A anotação {@link EnableMethodSecurity} é utilizada para habilitar a segurança baseada em métodos, o que permite
 * a proteção de métodos de serviço com anotações como {@code @PreAuthorize} e {@code @Secured}.
 * </p>
 */
@Configuration
@EnableMethodSecurity( prePostEnabled = true )
public class WebSecurityConfig {

    /**
     * Configura a segurança HTTP para o aplicativo.
     * <p>
     * Esta configuração:
     * <ul>
     *   <li>Desativa a proteção CSRF para o endpoint específico {@code /users/create}, permitindo que ele seja acessado sem
     *   um token CSRF.</li>
     *   <li>Permite que o endpoint {@code /users/create} seja acessado sem autenticação para requisições POST.</li>
     *   <li>Exige autenticação para todas as outras requisições.</li>
     *   <li>Configura a autenticação básica HTTP.</li>
     * </ul>
     * </p>
     *
     * @param http o objeto {@link HttpSecurity} usado para configurar a segurança HTTP
     * @return um {@link SecurityFilterChain} configurado com as regras de segurança definidas
     * @throws Exception se ocorrer um erro durante a configuração da segurança HTTP
     */
    @Bean
    public SecurityFilterChain securityFilterChain ( HttpSecurity http ) throws Exception {
        http
                .csrf( csrf -> csrf
                        .ignoringRequestMatchers( "/users/create" ) // Desativa CSRF para o endpoint específico
                )
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers( HttpMethod.POST, "/users/create" ).permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic( Customizer.withDefaults() );
        return http.build();
    }

    /**
     * Define um {@link PasswordEncoder} para a codificação de senhas.
     * <p>
     * Este {@link PasswordEncoder} usa o algoritmo BCrypt para codificar senhas, proporcionando uma forma segura de armazenar
     * senhas criptografadas.
     * </p>
     *
     * @return um {@link PasswordEncoder} configurado para usar BCrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
