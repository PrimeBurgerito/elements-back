package com.elements.elementsdomain.document.location;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = -1059083644L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocation location = new QLocation("location");

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

    public final SetPath<String, StringPath> nearbyLocations = this.<String, StringPath>createSet("nearbyLocations", String.class, StringPath.class, PathInits.DIRECT2);

    //inherited
    public final StringPath realmId = _super.realmId;

    public final com.elements.elementsdomain.shared.requirement.QRequirement requirement;

    public QLocation(String variable) {
        this(Location.class, forVariable(variable), INITS);
    }

    public QLocation(Path<? extends Location> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocation(PathMetadata metadata, PathInits inits) {
        this(Location.class, metadata, inits);
    }

    public QLocation(Class<? extends Location> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.requirement = inits.isInitialized("requirement") ? new com.elements.elementsdomain.shared.requirement.QRequirement(forProperty("requirement"), inits.get("requirement")) : null;
    }

}

