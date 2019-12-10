package oop.models.fact.impl;

import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.fact.Fact;

public class ObjectionFact implements Fact<ObjectionSubjectEntity, ObjectionObjectEntity> {
    private ObjectionSubjectEntity subject;
    private ObjectionObjectEntity object;
    private int originId;

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
    public int getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(int originId) {
        this.originId = originId;
    }
}