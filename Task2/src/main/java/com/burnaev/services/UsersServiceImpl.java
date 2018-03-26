package com.burnaev.services;

import com.burnaev.forms.UserUpdateForm;
import com.burnaev.models.User;
import com.burnaev.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public User getUser(Long id) {
        return usersRepository.findOne(id);
    }
    @Override
    public void update(Long id, UserUpdateForm userUpdateForm) {
        User user = usersRepository.findOne(id);
        userUpdateForm.updateUser(user);
        usersRepository.save(user);
    }
}
