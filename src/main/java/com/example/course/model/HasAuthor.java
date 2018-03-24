package com.example.course.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class HasAuthor extends PersistentObject{

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;
}
