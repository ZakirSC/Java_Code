package com.burnaev.forms;

import lombok.Data;

@Data
public class CreateFileForm {
    private String name;
    private String description;
    private String text;
}
