package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.fact.Fact;

public class CancellationFact implements Fact<CancellationSubjectEntity, CancellationObjectEntity> {

    @Override
    public CancellationSubjectEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(CancellationSubjectEntity subject) {
        

    }

    @Override
    public CancellationObjectEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(CancellationObjectEntity object) {
        

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