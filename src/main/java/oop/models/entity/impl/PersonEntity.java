package oop.models.entity.impl;

import java.time.Instant;

import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;

public class PersonEntity
        implements OrganizingSubjectEntity, SupportSubjectEntity, ObjectionSubjectEntity, CancellationSubjectEntity {
    private String id;
    private String label;
    private String content;
    private Instant birthday;
    private Instant dateOfDeath;
    private String occupation;

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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public Instant getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Instant dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}