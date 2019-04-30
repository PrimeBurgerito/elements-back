package com.elements.elementscommon.domain;

import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.Instant;

public class DocumentBase implements Serializable {
    private static final long serialVersionUID = -1553820110092250859L;

    @Id
    private String id;

    @CreatedDate
    private Instant created;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Instant modified;

    @LastModifiedBy
    private String modifiedBy;

    public DocumentBase() {
    }

    public DocumentBase(String id, Instant created, String createdBy, Instant modified, String modifiedBy) {
        this.id = id;
        this.created = created;
        this.createdBy = createdBy;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
