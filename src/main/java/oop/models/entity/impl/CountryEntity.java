package oop.models.entity.impl;

import oop.models.entity.object.HostingObjectEntity;
import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.object.SupportObjectEntity;
import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;

public class CountryEntity implements SupportSubjectEntity, ObjectionSubjectEntity, CancellationSubjectEntity,
        HostingObjectEntity, SupportObjectEntity, ObjectionObjectEntity {
    public enum Continent {
        ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA, AFRICA, ARTANTICA
    }

    public String getId() {
        return null;
    }

    public void setId(String id) {

    }

    public String getLabel() {
        return null;
    }

    public void setLabel(String label) {

    }

    public String getContent() {
        return null;
    }

    public void setContent(String content) {
        
    }

    public Continent getContinent() {
        return null;
    }

    public void setContinent(Continent continent) {

    }
}