package oop.models.fact.impl;

import oop.models.entity.impl.CountryEntity;
import oop.models.fact.Fact;

public class DealingFact implements Fact<CountryEntity, CountryEntity> {
    private String id;
    private CountryEntity subject;
    private CountryEntity object;
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
    public CountryEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(CountryEntity subject) {
        this.subject = subject;
    }

    @Override
    public CountryEntity getObject() {
        return object;
    }

    @Override
    public void setObject(CountryEntity object) {
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