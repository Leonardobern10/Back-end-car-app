package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.RegisterForAdminDTO;
import org.example.model.User;
import org.example.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/admin" )
public class AdminController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@link org.example.controller.UserController}.
     * <p>
     * O construtor é utilizado para injetar a dependência do serviço {@link CustomUserDetailsService}.
     * </p>
     *
     * @param customUserDetailsService o serviço responsável pela criação e gestão de usuários
     */
    public AdminController ( CustomUserDetailsService customUserDetailsService ) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Cria um novo usuário no sistema.
     * <p>
     * Este endpoint permite a criação de um novo usuário no sistema. Os detalhes do usuário são fornecidos
     * no corpo da requisição no formato JSON e são convertidos para um objeto {@link User}. O serviço
     * {@link CustomUserDetailsService} é utilizado para processar a criação do usuário.
     * </p>
     *
     * @param userData o objeto {@link User} contendo os detalhes do novo usuário a ser criado
     * @return uma {@link ResponseEntity} com uma mensagem de sucesso e status HTTP 200 (OK)
     */
    @PostMapping( "/create" )
    public ResponseEntity<String> createAdmin ( @RequestBody @Valid RegisterForAdminDTO userData ) {
        customUserDetailsService.createForAdmin( userData.username(), userData.password(), userData.role() );
        return ResponseEntity.ok( "USER CREATED SUCCESSFULLY" );
    }
}