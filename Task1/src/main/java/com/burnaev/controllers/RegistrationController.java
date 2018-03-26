package com.burnaev.controllers;

import com.burnaev.forms.RegistrationForm;
import com.burnaev.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute RegistrationForm registrationForm,
                                   @ModelAttribute("model") ModelMap modelMap) {
        String email = registrationService.registration(registrationForm);
        modelMap.addAttribute("email", email);
        return "user_pages/success";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "user_pages/registration_page";
    }

    @GetMapping("/confirm/{confirm-string}")
    public String getConfirmPage(@ModelAttribute("model") ModelMap modelMap,
                                 @PathVariable("confirm-string") String confirmString) {
        boolean result = registrationService.confirm(confirmString);
        modelMap.addAttribute("result", result);
        return "user_pages/confirm_result_page";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("model") ModelMap modelMap,
                        @RequestParam(value = "error", required = false) Boolean error) {
        if (error != null) {
            modelMap.addAttribute("error", true);
        } else {
            modelMap.addAttribute("error", false);
        }
        return "user_pages/login";
    }
}
