package oop.models.fact.impl;

import oop.models.entity.impl.EventEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.fact.Fact;

public class OrganizingFact implements Fact<OrganizingSubjectEntity, EventEntity> {
    private String id;
    private OrganizingSubjectEntity subject;
    private EventEntity object;
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
    public String getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(String originId) {
        this.originId = originId;
    }
}