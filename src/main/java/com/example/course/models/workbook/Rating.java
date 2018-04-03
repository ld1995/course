package com.example.course.models.workbook;

import com.example.course.models.HasAuthor;
import com.example.course.models.workbook.Workbook;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_rating_workbook")
@Data
public class Rating extends HasAuthor {

    @ManyToOne(fetch = FetchType.LAZY)
    private Workbook workbook;

    @Column(name = "mark")
    private int mark;

}
