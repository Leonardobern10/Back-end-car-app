package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RegisterForUserDTO;
import org.example.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para operações relacionadas aos usuários.
 * <p>
 * Fornece um endpoint para a criação de novos usuários no sistema.
 * </p>
 */
@RestController
@RequestMapping( "/users" )
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@code UserController}.
     * <p>
     * Injeta o serviço {@link CustomUserDetailsService} para gerenciar a criação de usuários.
     * </p>
     *
     * @param customUserDetailsService serviço responsável pela criação e gestão de usuários
     */
    public UserController ( CustomUserDetailsService customUserDetailsService ) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Cria um novo usuário.
     * <p>
     * Recebe os detalhes do usuário em formato JSON e utiliza o serviço {@link CustomUserDetailsService} para processar a criação.
     * </p>
     *
     * @param userData objeto {@link RegisterForUserDTO} com os dados do novo usuário
     * @return uma {@link ResponseEntity} com mensagem de sucesso e status HTTP 200 (OK)
     */
    @PostMapping( "/create" )
    public ResponseEntity<String> createUser ( @RequestBody @Valid RegisterForUserDTO userData ) {
        customUserDetailsService.createForUser( userData.username(), userData.email(), userData.password() );
        return ResponseEntity.ok( "USER CREATED SUCCESSFULLY" );
    }
}
