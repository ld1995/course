package com.example.course.dto;

import com.example.course.models.user.Role;
import lombok.Data;

@Data
public class UserDTO extends BasePersistenceDTO {

    private String username;

}
