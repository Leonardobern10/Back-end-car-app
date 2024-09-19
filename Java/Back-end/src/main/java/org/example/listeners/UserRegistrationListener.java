package org.example.listeners;

import org.example.events.UserRegisteredEvent;
import org.example.utils.EmailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Ouvinte de eventos de registro de usuário.
 * <p>
 * Esta classe escuta eventos do tipo {@link UserRegisteredEvent} e envia um e-mail quando um novo usuário
 * é registrado na aplicação.
 * </p>
 */
@Component
public class UserRegistrationListener {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Manipula eventos do tipo {@link UserRegisteredEvent}.
     * <p>
     * Quando um evento {@code UserRegisteredEvent} é recebido, este método cria uma mensagem de e-mail
     * informando sobre o novo usuário registrado e envia o e-mail para o endereço especificado.
     * </p>
     *
     * @param event o evento {@code UserRegisteredEvent} que contém informações sobre o novo usuário registrado
     */
    @EventListener
    public void handleUserRegisteredEvent ( UserRegisteredEvent event ) {
        String userEmail = event.getUser().getEmail();

        SimpleMailMessage message = new SimpleMailMessage();
        // Inserir email para recebimento
        message.setTo( EmailInfo.SET_TO );
        message.setSubject( EmailInfo.SET_SUBJECT );
        message.setText( EmailInfo.SET_TEXT + userEmail );

        mailSender.send( message );
    }
}
