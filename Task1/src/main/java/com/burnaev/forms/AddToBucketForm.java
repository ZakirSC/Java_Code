package com.burnaev.forms;


import lombok.Data;

@Data
public class AddToBucketForm {
    private Long userId;
    private Long carId;
    private Integer count;
}
