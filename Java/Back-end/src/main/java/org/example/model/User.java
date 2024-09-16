package org.example.model;

import jakarta.persistence.*;
import org.example.role.UserRole;

@Entity
@Table( name = "clients" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private String id;
    private String username;
    private String email;
    private String password;
    @Enumerated( EnumType.STRING )
    private UserRole role;

    public User () {
    }

    public User ( String username, String email, String password, UserRole role ) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId () {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getRole () {
        return role.getRole();
    }

    public void setRole ( UserRole role ) {
        this.role = role;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }
}
