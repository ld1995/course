package com.example.course.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
public class WorkbookDto extends BasePersistenceDto {

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private String title;

    @NotNull
    private String numberSpecialty;

    @NotNull
    private String content;

    private Date date = new Date();

    private Integer rating;

    private List<Long> questionsId = new ArrayList<>();

    private List<CommentDto> comments = new ArrayList<>();

    private List<String> tags = new ArrayList<>();
}
