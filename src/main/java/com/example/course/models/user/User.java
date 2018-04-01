package com.example.course.models.user;

import com.example.course.models.PersistentObject;
import com.example.course.models.comment.Comment;
import com.example.course.models.workbook.Workbook;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.*;

@Entity()
@Table(name = "course_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends PersistentObject {

    public User(String username, Role role, boolean blocked) {
        this.username = username;
        this.role = role;
        this.blocked = blocked;
    }

    @Column(name = "username", unique = true)
    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Workbook> workbooks = new HashSet<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    private boolean blocked = false;
}
