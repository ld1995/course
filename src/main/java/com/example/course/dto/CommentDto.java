package com.example.course.dto;

import lombok.Data;

@Data
public class CommentDto extends BasePersistenceDto {

//    private String workbook;
//
//    @Column(name = "date", columnDefinition="DATETIME")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
//    private Date date = new Date();
//
//    @Field
//    @Lob
//    @Column(name = "content")
//    private String content;
//
//    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<LikeComment> like = new HashSet<>();
//
//    @OneToMany(mappedBy = "parent")
//    private Set<Comment> comments = new HashSet<>();
//
//    @ManyToOne
//    private Comment parent;
}
