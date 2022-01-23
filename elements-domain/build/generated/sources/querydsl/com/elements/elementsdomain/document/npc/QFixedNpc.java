package com.elements.elementsdomain.document.npc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFixedNpc is a Querydsl query type for FixedNpc
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFixedNpc extends EntityPathBase<FixedNpc> {

    private static final long serialVersionUID = 1749090564L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFixedNpc fixedNpc = new QFixedNpc("fixedNpc");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final SetPath<com.elements.elementsdomain.shared.image.ConditionalImage, com.elements.elementsdomain.shared.image.QConditionalImage> images = this.<com.elements.elementsdomain.shared.image.ConditionalImage, com.elements.elementsdomain.shared.image.QConditionalImage>createSet("images", com.elements.elementsdomain.shared.image.ConditionalImage.class, com.elements.elementsdomain.shared.image.QConditionalImage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath realmId = _super.realmId;

    public final com.elements.elementsdomain.composite.npc.QNpcStatistics statistics;

    public QFixedNpc(String variable) {
        this(FixedNpc.class, forVariable(variable), INITS);
    }

    public QFixedNpc(Path<? extends FixedNpc> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFixedNpc(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFixedNpc(PathMetadata metadata, PathInits inits) {
        this(FixedNpc.class, metadata, inits);
    }

    public QFixedNpc(Class<? extends FixedNpc> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.statistics = inits.isInitialized("statistics") ? new com.elements.elementsdomain.composite.npc.QNpcStatistics(forProperty("statistics")) : null;
    }

}

