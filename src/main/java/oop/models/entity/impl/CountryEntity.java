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
        ASIA, EUROPE, NORTH_AMERICA, SOUTH_AMERICA, AFRICA, ARTANTICA;

        public static Continent fromId(int id) {
            return values()[id];
        }
    }

    private String id;
    private String label;
    private String content;
    private Continent continent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}