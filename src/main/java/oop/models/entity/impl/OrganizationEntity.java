package oop.models.entity.impl;

import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.subject.AttendingSubjectEntity;
import oop.models.entity.subject.OrganizingSubjectEntity;

public class OrganizationEntity implements OrganizingSubjectEntity, AttendingSubjectEntity, AttendingObjectEntity {
    private String id;
    private String label;
    private String content;
    private String field;
    private String baseOfOperation;

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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getBaseOfOperation() {
        return baseOfOperation;
    }

    public void setBaseOfOperation(String baseOfOperation) {
        this.baseOfOperation = baseOfOperation;
    }
}