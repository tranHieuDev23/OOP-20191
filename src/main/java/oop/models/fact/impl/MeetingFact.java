package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;

public class MeetingFact implements Fact<PersonEntity, PersonEntity> {

    @Override
    public PersonEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(PersonEntity subject) {
        

    }

    @Override
    public PersonEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(PersonEntity object) {
        

    }

    @Override
    public String getType() {
        return "MeetingFact";
    }

    @Override
    public Article getOrigin() {
        
        return null;
    }

    @Override
    public void setOrigin(Article origin) {
        

    }
}