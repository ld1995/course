package com.example.course.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CommentDto extends BasePersistenceDto {

//   private String workbook;

    private Date date = new Date();

    private String content;

    private Integer like;

    private List<Integer> comments = new ArrayList<>();

    private Integer parent;
}
