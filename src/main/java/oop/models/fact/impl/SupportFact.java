package oop.models.fact.impl;

import oop.models.entity.object.SupportObjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;
import oop.models.fact.Fact;

public class SupportFact implements Fact<SupportSubjectEntity, SupportObjectEntity> {
    private SupportSubjectEntity subject;
    private SupportObjectEntity object;
    private int originId;

    @Override
    public SupportSubjectEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(SupportSubjectEntity subject) {
        this.subject = subject;
    }

    @Override
    public SupportObjectEntity getObject() {
        return object;
    }

    @Override
    public void setObject(SupportObjectEntity object) {
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