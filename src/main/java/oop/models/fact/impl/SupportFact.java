package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.object.SupportObjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;
import oop.models.fact.Fact;

public class SupportFact implements Fact<SupportSubjectEntity, SupportObjectEntity> {

    @Override
    public SupportSubjectEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(SupportSubjectEntity subject) {
        

    }

    @Override
    public SupportObjectEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(SupportObjectEntity object) {
        

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