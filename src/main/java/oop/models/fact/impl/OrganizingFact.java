package oop.models.fact.impl;

import oop.models.entity.impl.EventEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.fact.Fact;

public class OrganizingFact implements Fact<OrganizingSubjectEntity, EventEntity> {
    private OrganizingSubjectEntity subject;
    private EventEntity object;
    private int originId;

    @Override
    public OrganizingSubjectEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(OrganizingSubjectEntity subject) {
        this.subject = subject;
    }

    @Override
    public EventEntity getObject() {
        return object;
    }

    @Override
    public void setObject(EventEntity object) {
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