package com.elements.elementsdomain.document.location.area;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocationArea is a Querydsl query type for LocationArea
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocationArea extends EntityPathBase<LocationArea> {

    private static final long serialVersionUID = -1690686476L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocationArea locationArea = new QLocationArea("locationArea");

    public final com.elements.elementscommon.domain.QDocumentBase _super = new com.elements.elementscommon.domain.QDocumentBase(this);

    public final SetPath<LocationInfo, QLocationInfo> children = this.<LocationInfo, QLocationInfo>createSet("children", LocationInfo.class, QLocationInfo.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final com.elements.elementsdomain.shared.image.QImage image;

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    public final StringPath parentAreaId = createString("parentAreaId");

    public final com.elements.elementsdomain.shared.requirement.QRequirement requirement;

    public final EnumPath<LocationArea.Type> type = createEnum("type", LocationArea.Type.class);

    public QLocationArea(String variable) {
        this(LocationArea.class, forVariable(variable), INITS);
    }

    public QLocationArea(Path<? extends LocationArea> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocationArea(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocationArea(PathMetadata metadata, PathInits inits) {
        this(LocationArea.class, metadata, inits);
    }

    public QLocationArea(Class<? extends LocationArea> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.image = inits.isInitialized("image") ? new com.elements.elementsdomain.shared.image.QImage(forProperty("image")) : null;
        this.requirement = inits.isInitialized("requirement") ? new com.elements.elementsdomain.shared.requirement.QRequirement(forProperty("requirement"), inits.get("requirement")) : null;
    }

}

