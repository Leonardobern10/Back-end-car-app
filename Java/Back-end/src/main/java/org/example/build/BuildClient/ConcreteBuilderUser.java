package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;

public class ConcreteBuilderUser implements BuilderUser {
    User user = null;

    public ConcreteBuilderUser () {
        user = new User();
    }

    @Override
    public void buildUsername ( String username ) {
        user.setUsername( username );
    }

    @Override
    public void buidEmail ( String email ) {
        user.setEmail( email );
    }

    @Override
    public void buildPassword ( String password ) {
        user.setPassword( password );
    }

    @Override
    public void buildRole ( UserRole role ) {
        user.setRole( role );
    }

    @Override
    public User buildUser () {
        return user;
    }
}
