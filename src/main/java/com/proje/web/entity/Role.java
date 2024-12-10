package com.proje.web.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, GUEST;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
