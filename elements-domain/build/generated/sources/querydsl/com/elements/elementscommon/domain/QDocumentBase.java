package com.elements.elementscommon.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDocumentBase is a Querydsl query type for DocumentBase
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QDocumentBase extends BeanPath<DocumentBase> {

    private static final long serialVersionUID = 1858228404L;

    public static final QDocumentBase documentBase = new QDocumentBase("documentBase");

    public final DateTimePath<java.time.Instant> created = createDateTime("created", java.time.Instant.class);

    public final StringPath createdBy = createString("createdBy");

    public final StringPath id = createString("id");

    public final DateTimePath<java.time.Instant> modified = createDateTime("modified", java.time.Instant.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public QDocumentBase(String variable) {
        super(DocumentBase.class, forVariable(variable));
    }

    public QDocumentBase(Path<? extends DocumentBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDocumentBase(PathMetadata metadata) {
        super(DocumentBase.class, metadata);
    }

}

