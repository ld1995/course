package com.example.course.dto;

import lombok.Data;

@Data
public class UserDto extends BasePersistenceDto {

    private String username;

    private Boolean blocked;

    private String role;
}
