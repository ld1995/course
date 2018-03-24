package com.example.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class PersistentObject {

    @Id
    @GeneratedValue
    private Long id;

}
