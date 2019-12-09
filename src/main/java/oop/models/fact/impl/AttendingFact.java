package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.subject.AttendingSubjectEntity;
import oop.models.fact.Fact;

public class AttendingFact implements Fact<AttendingSubjectEntity, AttendingObjectEntity> {

    @Override
    public AttendingSubjectEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(AttendingSubjectEntity subject) {
        

    }

    @Override
    public AttendingObjectEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(AttendingObjectEntity object) {
        

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