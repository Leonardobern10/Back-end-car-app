package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RegisterForUserDTO;
import org.example.routes.Routes;
import org.example.service.CustomUserDetailsService;
import org.example.utils.Notice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pelas operações relacionadas a usuários.
 * <p>
 * Este controlador expõe um endpoint para a criação de novos usuários no sistema.
 * </p>
 */
@RestController
@RequestMapping( Routes.USERS_ROUTE )
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@code UserController}.
     * <p>
     * Injeta o serviço {@link CustomUserDetailsService} para gerenciar a criação de usuários.
     * </p>
     *
     * @param customUserDetailsService serviço responsável pela criação e gestão de usuários.
     */
    public UserController ( CustomUserDetailsService customUserDetailsService ) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Cria um novo usuário no sistema.
     * <p>
     * Este endpoint recebe os detalhes do usuário em formato JSON e utiliza o serviço {@link CustomUserDetailsService}
     * para processar a criação do usuário. O método responde com uma mensagem de sucesso e o status HTTP 200 (OK).
     * </p>
     *
     * @param userData objeto {@link RegisterForUserDTO} contendo os dados do novo usuário.
     * @return uma {@link ResponseEntity} com a mensagem "USER CREATED SUCCESSFULLY" e o status HTTP 200 (OK).
     */
    @PostMapping( Routes.CREATE_ROUTE )
    public ResponseEntity<String> createUser ( @RequestBody @Valid RegisterForUserDTO userData ) {
        customUserDetailsService.createForUser( userData.username(), userData.email(), userData.password() );
        return ResponseEntity.ok( Notice.USER_CREATED );
    }
}
