package oop.models.fact.impl;

import oop.models.entity.impl.PersonEntity;
import oop.models.fact.Fact;

public class MeetingFact implements Fact<PersonEntity, PersonEntity> {
    private String id;
    private PersonEntity subject;
    private PersonEntity object;
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
    public String getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(String originId) {
        this.originId = originId;
    }
}