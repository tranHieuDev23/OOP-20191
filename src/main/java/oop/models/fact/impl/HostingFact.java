package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.impl.EventEntity;
import oop.models.entity.object.HostingObjectEntity;
import oop.models.fact.Fact;

public class HostingFact implements Fact<EventEntity, HostingObjectEntity> {

    @Override
    public EventEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(EventEntity subject) {
        

    }

    @Override
    public HostingObjectEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(HostingObjectEntity object) {
        

    }

    @Override
    public String getType() {
        
        return null;
    }

    @Override
    public Article getOrigin() {
        
        return null;
    }

    @Override
    public void setOrigin(Article origin) {
        

    }
}