package com.elements.elementscommon.domain;

import com.arangodb.springframework.annotation.ArangoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentBase {
    @ArangoId
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
