package com.elements.elementsdomain.document;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRealmDocument is a Querydsl query type for RealmDocument
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QRealmDocument extends BeanPath<RealmDocument> {

    private static final long serialVersionUID = -381324224L;

    public static final QRealmDocument realmDocument = new QRealmDocument("realmDocument");

    public final com.elements.elementscommon.domain.QDocumentBase _super = new com.elements.elementscommon.domain.QDocumentBase(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath realmId = createString("realmId");

    public QRealmDocument(String variable) {
        super(RealmDocument.class, forVariable(variable));
    }

    public QRealmDocument(Path<? extends RealmDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRealmDocument(PathMetadata metadata) {
        super(RealmDocument.class, metadata);
    }

}

