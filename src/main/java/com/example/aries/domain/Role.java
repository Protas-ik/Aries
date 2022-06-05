package com.example.aries.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    WORKER, // рабочий
    USER, // клиент
    DIRECTOR, // директор
    ADMINISTRATOR; // администратор

    @Override
    public String getAuthority()
    {
        return name();
    }
}
