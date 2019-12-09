package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.fact.Fact;

public class OrganizingFact implements Fact<OrganizingSubjectEntity, EventEntity> {

    @Override
    public OrganizingSubjectEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(OrganizingSubjectEntity subject) {
        

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