package com.example.course.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity()
@Table(name = "course_user")
@Data
public class User extends PersistentObject {

    @Column(name = "username")
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Workbook> workbooks = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    private boolean blocked;
}
