package org.example.model;

public enum UserRole {

    USER_ROLE("user"),
    ADMIN_ROLE("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
