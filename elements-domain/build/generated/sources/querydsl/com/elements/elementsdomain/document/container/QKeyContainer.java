package com.elements.elementsdomain.document.container;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKeyContainer is a Querydsl query type for KeyContainer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeyContainer extends EntityPathBase<KeyContainer> {

    private static final long serialVersionUID = -1213183367L;

    public static final QKeyContainer keyContainer = new QKeyContainer("keyContainer");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath key = createString("key");

    public final SetPath<Key, QKey> keys = this.<Key, QKey>createSet("keys", Key.class, QKey.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final StringPath realmId = _super.realmId;

    public QKeyContainer(String variable) {
        super(KeyContainer.class, forVariable(variable));
    }

    public QKeyContainer(Path<? extends KeyContainer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKeyContainer(PathMetadata metadata) {
        super(KeyContainer.class, metadata);
    }

}

