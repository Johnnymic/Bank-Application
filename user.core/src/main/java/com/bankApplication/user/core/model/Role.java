package com.bankApplication.user.core.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    READ_PRIVILLAGE,
    WRITE_PRIVILLAGE;
    ;

    @Override
    public String getAuthority() {
        return null;
    }


}
