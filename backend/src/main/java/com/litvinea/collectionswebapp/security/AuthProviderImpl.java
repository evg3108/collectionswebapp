package com.litvinea.collectionswebapp.security;

import com.litvinea.collectionswebapp.service.UserSecurityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserSecurityDetailsService userSecurityDetailsService;

    @Autowired
    public AuthProviderImpl(UserSecurityDetailsService userSecurityDetailsService) {
        this.userSecurityDetailsService = userSecurityDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails details = userSecurityDetailsService.loadUserByUsername(authentication.getName());
        String password = authentication.getCredentials().toString();
        if (!password.equals(details.getPassword())){
            throw new BadCredentialsException("Password incorrect!");
        }
        return new UsernamePasswordAuthenticationToken(details, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
