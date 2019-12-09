package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.fact.Fact;

public class ObjectionFact implements Fact<ObjectionSubjectEntity, ObjectionObjectEntity> {

    @Override
    public ObjectionSubjectEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(ObjectionSubjectEntity subject) {
        

    }

    @Override
    public ObjectionObjectEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(ObjectionObjectEntity object) {
        

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