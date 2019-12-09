package oop.models.entity.impl;

import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.object.SupportObjectEntity;

public class AgreementEntity
        implements AttendingObjectEntity, SupportObjectEntity, ObjectionObjectEntity, CancellationObjectEntity {
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
}