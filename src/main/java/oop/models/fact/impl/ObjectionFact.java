package oop.models.fact.impl;

import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.fact.Fact;

public class ObjectionFact implements Fact<ObjectionSubjectEntity, ObjectionObjectEntity> {
    private String id;
    private ObjectionSubjectEntity subject;
    private ObjectionObjectEntity object;
    private String originId;

    @Override 
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public ObjectionSubjectEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(ObjectionSubjectEntity subject) {
        this.subject = subject;
    }

    @Override
    public ObjectionObjectEntity getObject() {
        return object;
    }

    @Override
    public void setObject(ObjectionObjectEntity object) {
        this.object = object;
    }

    @Override
    public String getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(String originId) {
        this.originId = originId;
    }
}