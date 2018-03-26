package com.burnaev.forms;

import com.burnaev.models.User;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserUpdateForm {
    private String name;
    private String email;
    private String password;
    public void updateUser(User user){
        user.setName(this.name);
    }
}
