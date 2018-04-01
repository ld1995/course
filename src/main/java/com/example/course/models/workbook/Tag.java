package com.example.course.models.workbook;

import com.example.course.models.PersistentObject;
import com.example.course.models.workbook.Workbook;
import lombok.Data;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_tag")
@Data
public class Tag extends PersistentObject {

    @Column(name = "name")
    @Field
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tag_workbook",
            joinColumns = { @JoinColumn(name = "tag_id") },
            inverseJoinColumns = { @JoinColumn(name = "workbook_id") }
    )
    private Set<Workbook> workbooks = new HashSet<>();
}
