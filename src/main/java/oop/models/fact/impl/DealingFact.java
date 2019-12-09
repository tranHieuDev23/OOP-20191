package oop.models.fact.impl;

import oop.models.article.Article;
import oop.models.entity.impl.CountryEntity;
import oop.models.fact.Fact;

public class DealingFact implements Fact<CountryEntity, CountryEntity> {

    @Override
    public CountryEntity getSubject() {
        
        return null;
    }

    @Override
    public void setSubject(CountryEntity subject) {
        

    }

    @Override
    public CountryEntity getObject() {
        
        return null;
    }

    @Override
    public void setObject(CountryEntity object) {
        

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