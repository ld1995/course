package com.example.course.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(exclude = {"comments"}, callSuper = false)
public class CommentDto extends BasePersistenceDto {

    @NotNull
    private String username;

    @NotNull
    private Long workbookId;

    private Date date = new Date();

    @NotNull
    private String content;

    private Integer like;

    private List<CommentDto> comments = new ArrayList<>();

    private Long parentId;
}