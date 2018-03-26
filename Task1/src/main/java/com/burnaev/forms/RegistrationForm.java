package com.burnaev.forms;


import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class RegistrationForm {
    private String name;
    private String homeTown;
    private String email;
    private String password;
}
