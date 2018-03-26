package com.burnaev.services;


import com.burnaev.forms.UserUpdateForm;
import com.burnaev.models.User;

public interface UserService {
    User getUser(Long id);
    void update(Long id, UserUpdateForm form);
}
