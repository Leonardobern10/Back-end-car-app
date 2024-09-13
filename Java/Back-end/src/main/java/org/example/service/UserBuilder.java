package org.example.service;

import org.example.model.User;
import org.example.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserBuilder {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserBuilder ( PasswordEncoder passwordEncoder ) {
        this.passwordEncoder = passwordEncoder;
    }

    public User builder ( String username, String password, UserRole role ) {
        User user = new User();
        user.setUsername( username );
        user.setPassword( passwordEncoder.encode( password ) );
        user.setRole( role );
        return user;
    }
}
