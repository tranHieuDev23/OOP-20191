package oop.models.fact.impl;

import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.subject.AttendingSubjectEntity;
import oop.models.fact.Fact;

public class AttendingFact implements Fact<AttendingSubjectEntity, AttendingObjectEntity> {
    private String id;
    private AttendingSubjectEntity subject;
    private AttendingObjectEntity object;
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
    public AttendingSubjectEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(AttendingSubjectEntity subject) {
        this.subject = subject;
    }

    @Override
    public AttendingObjectEntity getObject() {
        return object;
    }

    @Override
    public void setObject(AttendingObjectEntity object) {
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