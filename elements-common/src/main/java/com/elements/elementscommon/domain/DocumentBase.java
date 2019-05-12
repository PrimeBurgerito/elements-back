package com.elements.elementscommon.domain;

import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Data
public abstract class DocumentBase {
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
}
