package com.example.course.model.like;

import com.example.course.model.HasAuthor;
import com.example.course.model.Workbook;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_like_workbook")
@Data
public class LikeWorkbook extends HasAuthor {

    @ManyToOne(fetch = FetchType.LAZY)
    private Workbook workbook;

}
