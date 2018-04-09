package com.example.course.models.workbook;

import com.example.course.models.HasAuthor;
import com.example.course.models.comment.Comment;
import com.example.course.models.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course_workbook")
@Data
@Indexed
@AllArgsConstructor
@NoArgsConstructor
@AnalyzerDef(name = "customarily",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class,
                params = {
                        @Parameter(name = "language", value = "Russian")
                })
        })
public class Workbook extends HasAuthor {

    @Column(name = "name")
    @Analyzer(definition = "customarily")
    private String name;

    @Column(name = "title")
    @Analyzer(definition = "customarily")
    private String title;

    @Column(name = "number_specialty")
    @Analyzer(definition = "customarily")
    private String numberSpecialty;

    @Lob
    @Column(name = "content")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Analyzer(definition = "customarily")
    private String content;

    @Column(name = "date", columnDefinition="DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> rating = new HashSet<>();

    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions = new HashSet<>();

    @IndexedEmbedded
    @OneToMany(mappedBy = "workbook", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @IndexedEmbedded
    @ManyToMany()
    private Set<Tag> tags = new HashSet<>();
}
