package org.example.events;

import org.example.model.User;
import org.springframework.context.ApplicationEvent;

/**
 * Evento que representa o registro de um novo usuário.
 * <p>
 * Este evento é acionado quando um novo usuário é registrado no sistema e
 * pode ser usado para desencadear ações pós-registro, como enviar um e-mail
 * de boas-vindas ou executar outras tarefas relacionadas ao usuário recém-criado.
 * </p>
 */
public class UserRegisteredEvent extends ApplicationEvent {

    private final User user;

    /**
     * Construtor para criar um novo evento de registro de usuário.
     *
     * @param user o objeto {@link User} associado a este evento.
     */
    public UserRegisteredEvent ( User user ) {
        super( user );
        this.user = user;
    }

    /**
     * Retorna o usuário associado a este evento.
     *
     * @return o objeto {@link User} que foi registrado.
     */
    public User getUser () {
        return user;
    }
}
