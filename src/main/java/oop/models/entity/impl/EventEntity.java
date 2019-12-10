package oop.models.entity.impl;

import oop.models.entity.object.AttendingObjectEntity;
import oop.models.entity.object.CancellationObjectEntity;
import oop.models.entity.object.ObjectionObjectEntity;
import oop.models.entity.object.SupportObjectEntity;

public class EventEntity
        implements AttendingObjectEntity, SupportObjectEntity, ObjectionObjectEntity, CancellationObjectEntity {
    private String id;
    private String label;
    private String content;

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
}