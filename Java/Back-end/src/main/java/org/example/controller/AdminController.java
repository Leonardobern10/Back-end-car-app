package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.RegisterForAdminDTO;
import org.example.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador responsável por operações administrativas relacionadas a usuários.
 * <p>
 * Permite a criação de novos usuários com privilégios de administrador.
 * </p>
 */
@RestController
@RequestMapping( "/admin" )
public class AdminController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@code AdminController}.
     * <p>
     * Injeta o serviço {@link CustomUserDetailsService} para lidar com a lógica de criação e gerenciamento de usuários.
     * </p>
     *
     * @param customUserDetailsService serviço responsável por criar e gerenciar usuários
     */
    public AdminController ( CustomUserDetailsService customUserDetailsService ) {
        this.customUserDetailsService = customUserDetailsService;
    }


    /**
     * Endpoint para criar um novo usuário com privilégios administrativos.
     * <p>
     * Recebe os dados do novo usuário em formato JSON, os valida e utiliza o serviço {@link CustomUserDetailsService}
     * para processar a criação do usuário.
     * </p>
     *
     * @param userData objeto {@link RegisterForAdminDTO} contendo os detalhes do novo usuário
     * @return uma {@link ResponseEntity} com uma mensagem de sucesso e status HTTP 200 (OK)
     */
    @PostMapping( "/create" )
    public ResponseEntity<String> createAdmin ( @RequestBody @Valid RegisterForAdminDTO userData ) {
        customUserDetailsService.createForAdmin( userData.username(), userData.email(), userData.password(), userData.role() );
        return ResponseEntity.ok( "USER CREATED SUCCESSFULLY" );
    }
}