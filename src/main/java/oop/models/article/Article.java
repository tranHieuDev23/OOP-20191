package oop.models.article;

import java.time.Instant;
import java.util.List;

import oop.models.entity.Entity;
import oop.models.fact.Fact;

public class Article {
    private String id;
    private String url;
    private Instant publishedDate;
    private List<Fact<? extends Entity, ? extends Entity>> extractedFacts;

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

    public Instant getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Instant publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<Fact<? extends Entity, ? extends Entity>> getExtractedFacts() {
        return this.extractedFacts;
    }

    public void setExtractedFacts(List<Fact<? extends Entity, ? extends Entity>> extractedFacts) {
        this.extractedFacts = extractedFacts;
    }
}