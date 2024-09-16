package org.example.build.BuildClient;

import org.example.model.User;
import org.example.role.UserRole;

public interface BuilderUser {
    void buildUsername ( String username );

    void buidEmail ( String email );

    void buildPassword ( String password );

    void buildRole ( UserRole role );

    User buildUser ();
}
