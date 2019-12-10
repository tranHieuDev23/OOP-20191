package oop.models.fact.impl;

import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.fact.Fact;

public class CancellationFact implements Fact<CancellationSubjectEntity, CancellationObjectEntity> {
    private CancellationSubjectEntity subject;
    private CancellationObjectEntity object;
    private int originId;

    @Override
    public CancellationSubjectEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(CancellationSubjectEntity subject) {
        this.subject = subject;
    }

    @Override
    public CancellationObjectEntity getObject() {
        return object;
    }

    @Override
    public void setObject(CancellationObjectEntity object) {
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