package com.example.course.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RatingDto extends BasePersistenceDto {

    @NotNull
    private String author;

    @NotNull
    private Long workbookId;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer mark;
}
