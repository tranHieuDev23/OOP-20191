package oop.models.article;

import java.util.Date;
import java.util.List;

import oop.models.entity.Entity;
import oop.models.fact.Fact;

public class Article {
    private String id;
    private String url;
    private Date publishedDate;
    private List<Fact<Entity, Entity>> extractedFacts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Fact<Entity, Entity>> getExtractedFacts() {
        return this.extractedFacts;
    }

    public void setExtractedFacts(List<Fact<Entity, Entity>> extractedFacts) {
        this.extractedFacts = extractedFacts;
    }
}