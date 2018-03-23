package com.example.demo.model;

import com.example.demo.model.like.LikePrecis;
import java.util.Date;
import lombok.Data;
import org.hibernate.search.annotations.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Indexed
@Entity
@Table(name = "demo_precis")
@Data
public class Precis extends PersistentObject {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content_processed")
    private String processedContent;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "demo_precis", cascade = CascadeType.ALL, orphanRemoval = true)
    private LikePrecis like;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

}
