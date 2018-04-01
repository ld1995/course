package com.example.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BasePersistenceDTO {

    @JsonIgnore
    private Long id;
}
