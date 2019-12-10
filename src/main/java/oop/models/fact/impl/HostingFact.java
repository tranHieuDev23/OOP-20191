package oop.models.fact.impl;

import oop.models.entity.impl.EventEntity;
import oop.models.entity.object.HostingObjectEntity;
import oop.models.fact.Fact;

public class HostingFact implements Fact<EventEntity, HostingObjectEntity> {
    private EventEntity subject;
    private HostingObjectEntity object;
    private int originId;

    @Override
    public EventEntity getSubject() {
        return subject;
    }

    @Override
    public void setSubject(EventEntity subject) {
        this.subject = subject;
    }

    @Override
    public HostingObjectEntity getObject() {
        return object;
    }

    @Override
    public void setObject(HostingObjectEntity object) {
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