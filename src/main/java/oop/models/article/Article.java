package oop.models.article;

import java.util.Date;
import java.util.List;

import oop.models.entity.Entity;
import oop.models.fact.Fact;

public interface Article {
    public String getId();
    public void setId(String id);
    public String getUrl();
    public void setUrl(String url);
    public Date getPublishedDate();
    public void setPublishedDate(Date publishedDate);
    public List<Fact<Entity, Entity>> getExtractedFacts();
}