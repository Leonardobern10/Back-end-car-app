package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DirectorUser {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User construct ( BuilderUser builderUser, String username, String email, String password, UserRole role ) {
        builderUser.buildUsername( username );
        builderUser.buidEmail( email );
        builderUser.buildPassword( passwordEncoder.encode( password ) );
        builderUser.buildRole( role );
        return builderUser.buildUser();
    }
}
