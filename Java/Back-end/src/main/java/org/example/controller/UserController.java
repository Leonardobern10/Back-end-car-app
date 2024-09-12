package org.example.controller;

import org.example.model.User;
import org.example.service.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pela gestão de operações relacionadas aos usuários.
 * <p>
 * Este controlador expõe um endpoint para a criação de novos usuários no sistema.
 * A criação do usuário é realizada através do serviço {@link CustomUserDetailsService}.
 * </p>
 */
@RestController
@RequestMapping( "/users" )
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;

    /**
     * Construtor da classe {@link UserController}.
     * <p>
     * O construtor é utilizado para injetar a dependência do serviço {@link CustomUserDetailsService}.
     * </p>
     *
     * @param customUserDetailsService o serviço responsável pela criação e gestão de usuários
     */
    public UserController ( CustomUserDetailsService customUserDetailsService ) {
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
     * @param user o objeto {@link User} contendo os detalhes do novo usuário a ser criado
     * @return uma {@link ResponseEntity} com uma mensagem de sucesso e status HTTP 200 (OK)
     */
    @PostMapping( "/create" )
    public ResponseEntity<String> createUser ( @RequestBody User user ) {
        customUserDetailsService.createUser( user.getUsername(), user.getPassword(), user.getRole() );
        return ResponseEntity.ok( "USER CREATED SUCCESSFULLY" );
    }
}
