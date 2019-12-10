package oop.models.entity.impl;

import java.util.Date;

import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;

public class PersonEntity
        implements OrganizingSubjectEntity, SupportSubjectEntity, ObjectionSubjectEntity, CancellationSubjectEntity {
    private String id;
    private String label;
    private String content;
    private Date birthday;
    private Date dateOfDeath;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}