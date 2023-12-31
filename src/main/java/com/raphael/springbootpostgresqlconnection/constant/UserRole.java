package com.raphael.springbootpostgresqlconnection.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("Admin"),
    USER("User"),
    GUEST("Guest"),
    PREMIUM_USER("Premium");

    private final String roleName;
}
