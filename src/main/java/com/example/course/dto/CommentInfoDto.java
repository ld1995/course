package com.example.course.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CommentInfoDto extends BasePersistenceDto {

    @NotNull
    private String username;

    @NotNull
    private Long workbookId;

    private Date date = new Date();

    @NotNull
    private String content;

    private Integer like;

    private Long parentId;
}
