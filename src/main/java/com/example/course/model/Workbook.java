package com.example.course.model;

import com.example.course.model.like.LikeWorkbook;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "course_workbook")
@Data
public class Workbook extends HasAuthor {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LikeWorkbook> likes = new HashSet<>();

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

}
