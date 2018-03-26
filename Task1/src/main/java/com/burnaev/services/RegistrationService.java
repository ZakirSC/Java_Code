package com.burnaev.services;


import com.burnaev.forms.RegistrationForm;

public interface RegistrationService {
    String registration(RegistrationForm registrationForm);
    boolean confirm(String confirmString);
}
