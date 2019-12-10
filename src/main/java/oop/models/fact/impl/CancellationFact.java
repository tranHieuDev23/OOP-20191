package oop.models.fact.impl;

import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.fact.Fact;

public class CancellationFact implements Fact<CancellationSubjectEntity, CancellationObjectEntity> {
    private String id;
    private CancellationSubjectEntity subject;
    private CancellationObjectEntity object;
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
    public String getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(String originId) {
        this.originId = originId;
    }
}