package com.burnaev.controllers;

import com.burnaev.models.User;
import com.burnaev.services.AuthenticationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class CommonData {
    @Autowired
    private AuthenticationService authenticationService;


    @SneakyThrows
    public void dataToModel(ModelMap modelMap, Authentication authentication) {
        if (authentication != null) {
            User user = authenticationService.getUserByAuthentication(authentication);
            modelMap.addAttribute("user", user);
        }
    }
}
