package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity()
@Table(name = "demo_user")
@Data
public class User extends PersistentObject {

    @Column(name = "username")
    private String username;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany(mappedBy = "demo_user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Precis> precis = new HashSet<>();

    private boolean block;

}
