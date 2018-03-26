package com.burnaev.services;


import com.burnaev.models.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
