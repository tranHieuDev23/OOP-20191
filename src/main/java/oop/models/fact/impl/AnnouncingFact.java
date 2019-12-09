package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;

public class AnnouncingFact implements Fact<PersonEntity, EventEntity> {

    @Override
    public PersonEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(PersonEntity subject) {
        

    }

    @Override
    public EventEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(EventEntity object) {
        

    }

    @Override
    public String getType() {
        
        return null;
    }

    @Override
    public Article getOrigin() {
        
        return null;
    }

    @Override
    public void setOrigin(Article origin) {
        

    }
    
}