package oop.models.entity.impl;

import java.util.Date;

import oop.models.entity.subject.CancellationSubjectEntity;
import oop.models.entity.subject.ObjectionSubjectEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;
import oop.models.entity.subject.SupportSubjectEntity;

public class PersonEntity
        implements OrganizingSubjectEntity, SupportSubjectEntity, ObjectionSubjectEntity, CancellationSubjectEntity {
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

    public String getOccupation() {
        return null;
    }

    public void setOccupation(String occupation) {

    }

    public Date getBirthday() {
        return null;
    }

    public void setBirthday(Date birthday) {

    }

    public Date getDateOfDeath() {
        return null;
    }

    public void setDateOfDeath(Date dateOfDeath) {

    }
}