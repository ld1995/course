package com.example.demo.model.like;

import com.example.demo.model.PersistentObject;
import com.example.demo.model.Precis;
import com.example.demo.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "demo_like_precis")
@Data
public class LikePrecis extends PersistentObject {

    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "precis_id")
    private Precis precis;

}
