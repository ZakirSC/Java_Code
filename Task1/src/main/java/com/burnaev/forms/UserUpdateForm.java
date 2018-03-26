package com.burnaev.forms;

import com.burnaev.models.User;
import lombok.Data;

@Data
public class UserUpdateForm {
    private String name;
    private String homeTown;
    private String email;
    private String password;
    public void updateUser(User user){
        user.setName(this.name);
        user.setHomeTown(this.homeTown);
        user.setEmail(this.email);
        user.setPassword(this.password);
    }
}
