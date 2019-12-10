package oop.models.fact.impl;

import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;

public class MeetingFact implements Fact<PersonEntity, PersonEntity> {
    private PersonEntity subject;
    private PersonEntity object;
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
    public PersonEntity getObject() {
        return object;
    }

    @Override
    public void setObject(PersonEntity object) {
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