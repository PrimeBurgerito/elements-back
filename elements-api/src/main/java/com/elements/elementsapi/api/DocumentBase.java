package com.elements.elementsapi.api;

import com.arangodb.entity.Entity;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Data
public abstract class DocumentBase implements Entity {
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
