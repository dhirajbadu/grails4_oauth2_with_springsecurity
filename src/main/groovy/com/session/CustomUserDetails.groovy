package com.session;

import grails.plugin.springsecurity.userdetails.GrailsUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetails extends GrailsUser {

    private AccessLevel accessLevel;

    CustomUserDetails(String username, String password, boolean enabled,
                      boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<GrantedAuthority> authorities,
                      long id , AccessLevel accessLevel) {
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities, id);
        this.accessLevel = accessLevel
    }

    AccessLevel getAccessLevel() {
        return accessLevel
    }
}
