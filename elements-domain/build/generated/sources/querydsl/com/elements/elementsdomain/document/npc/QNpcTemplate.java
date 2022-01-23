package com.elements.elementsdomain.document.npc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNpcTemplate is a Querydsl query type for NpcTemplate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNpcTemplate extends EntityPathBase<NpcTemplate> {

    private static final long serialVersionUID = -738340636L;

    public static final QNpcTemplate npcTemplate = new QNpcTemplate("npcTemplate");

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

    public final NumberPath<Long> rank = createNumber("rank", Long.class);

    //inherited
    public final StringPath realmId = _super.realmId;

    public QNpcTemplate(String variable) {
        super(NpcTemplate.class, forVariable(variable));
    }

    public QNpcTemplate(Path<? extends NpcTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNpcTemplate(PathMetadata metadata) {
        super(NpcTemplate.class, metadata);
    }

}

