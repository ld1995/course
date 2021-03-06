package com.example.course.models.comment;

import com.example.course.models.HasAuthor;
import com.example.course.models.workbook.Workbook;
import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Indexed
@EqualsAndHashCode(callSuper = false, exclude = {"workbook","comments"})
public class Comment extends HasAuthor {

    @ManyToOne
    private Workbook workbook;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Field
    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> like = new HashSet<>();

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    private Comment parent;
}
