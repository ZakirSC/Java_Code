package com.burnaev.controllers;

import com.burnaev.forms.UserUpdateForm;
import com.burnaev.models.User;
import com.burnaev.services.AuthenticationService;
import com.burnaev.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private CommonData commonData;

    @GetMapping("/")
    public String getHomePage(@ModelAttribute("model") ModelMap modelMap,
                              Authentication authentication){
        commonData.dataToModel(modelMap, authentication);
        return "home_page";
    }
    @GetMapping("/profile")
    public String getProfilePage(@ModelAttribute("model") ModelMap modelMap,
                                 Authentication authentication) {
        commonData.dataToModel(modelMap, authentication);
        return "user_pages/profile";
    }

    @GetMapping("/update_profile")
    public String getUpdateProfilePage(@ModelAttribute("model") ModelMap modelMap,
                                       Authentication authentication) {
        commonData.dataToModel(modelMap, authentication);
        return "user_pages/update_user_page";
    }

    @PostMapping("/update_profile")
    @ResponseBody
    public ResponseEntity<Object> updateUser(UserUpdateForm userUpdateForm,
                                             @RequestParam(value = "id") Long id) {
        usersService.update(id, userUpdateForm);
        return ResponseEntity.accepted().build();
    }
}
