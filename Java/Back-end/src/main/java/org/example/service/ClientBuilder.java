package org.example.service;

import org.example.model.User;
import org.example.model.UserRole;
import org.example.repository.UserRepository;
import org.example.validations.StringValidation;
import org.springframework.security.authentication.BadCredentialsException;


public class ClientBuilder {

    private static UserBuilder userBuilder;
    private static UserRepository userRepository;

    public ClientBuilder ( UserBuilder userBuilder ) {
        ClientBuilder.userBuilder = userBuilder;
    }

    public static User builder ( String username, String password, UserRole role ) {
        StringValidation.validate( username, "FIELD USERNAME IS NOT VALID" + username );
        StringValidation.validatePassword( password,
                "THIS PASSWORD IS INVALID! IT NEEDS: LETTERS, NUMBERS E SPECIAL CARACTERS..." );
        if ( userRepository.findByUsername( username ) != null )
            throw new BadCredentialsException( "USERNAME INVALID" );

        StringValidation.validate( role.getRole(), "THIS ROLE IS INVALID" + role.getRole() );

        return userBuilder.builder( username, password, UserRole.USER_ROLE );
    }
}
