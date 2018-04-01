package com.example.course.models.question;

import com.example.course.models.HasAuthor;
import com.example.course.models.workbook.Workbook;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course_question")
@Data
public class Question extends HasAuthor {

    @ManyToOne
    private Workbook workbook;

    @Column(name = "content")
    private String content;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
}
