package com.example.course.dto;

import lombok.Data;

import java.util.*;

@Data
public class WorkbookDTO extends BasePersistenceDTO{

    private UserDTO user;

    private String name;

    private String title;

    private String numberSpecialty;

    private String content;

    private Date date;

    private int rating;

    private List<Long> questionsId = new ArrayList<>();

    private List<Long> commentsId = new ArrayList<>();

    private List<String> tags = new ArrayList<>();
}
