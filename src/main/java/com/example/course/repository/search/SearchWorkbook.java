package com.example.course.repository.search;

import com.example.course.models.workbook.Workbook;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SearchWorkbook {

    @PersistenceContext
    private EntityManager entityManager;

    public List searchWorkbook(String query) {
        Query luceneQuery = getQueryBuilder().keyword().onFields("content","comments.content", "tags.name")//, "name", "title","numberSpecialty"
                .matching(query).createQuery();
        return  getJpaQuery(luceneQuery).getResultList();
    }

    private FullTextQuery getJpaQuery(Query luceneQuery) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        return fullTextEntityManager.createFullTextQuery(luceneQuery, Workbook.class);
    }

    private QueryBuilder getQueryBuilder() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        return fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Workbook.class)
                .get();
    }

    public static List<String> tokenizeString(Analyzer analyzer, String string) throws IOException {
        List<String> result = new ArrayList<String>();
        try (TokenStream stream = analyzer.tokenStream(null, new StringReader(string))){
            stream.reset();
            while (stream.incrementToken()) {
                result.add(stream.getAttribute(CharTermAttribute.class).toString());
            }
        }
        return result;
    }
}
