package oop.models.fact.impl;

import oop.models.entity.impl.CountryEntity;
import oop.models.fact.Fact;

public class TensionFact implements Fact<CountryEntity, CountryEntity> {
    private CountryEntity subject;
    private CountryEntity object;
    private int originId;

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
    public int getOriginId() {
        return originId;
    }

    @Override
    public void setOriginId(int originId) {
        this.originId = originId;
    }
}