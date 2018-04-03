package com.example.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BasePersistenceDto {

//    @JsonIgnore
    private Long id;
}
