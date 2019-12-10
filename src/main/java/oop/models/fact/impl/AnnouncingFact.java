package oop.models.fact.impl;

import oop.models.entity.impl.EventEntity;
import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;

public class AnnouncingFact implements Fact<PersonEntity, EventEntity> {
    private PersonEntity subject;
    private EventEntity object;
    private int originId;

    @Override
    public PersonEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(PersonEntity subject) {
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