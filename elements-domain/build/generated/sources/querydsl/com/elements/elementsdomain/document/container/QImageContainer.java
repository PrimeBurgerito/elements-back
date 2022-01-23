package com.elements.elementsdomain.document.container;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImageContainer is a Querydsl query type for ImageContainer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImageContainer extends EntityPathBase<ImageContainer> {

    private static final long serialVersionUID = -1130114755L;

    public static final QImageContainer imageContainer = new QImageContainer("imageContainer");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final SetPath<com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage> images = this.<com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage>createSet("images", com.elements.elementsdomain.shared.image.Image.class, com.elements.elementsdomain.shared.image.QImage.class, PathInits.DIRECT2);

    public final StringPath key = createString("key");

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final StringPath realmId = _super.realmId;

    public QImageContainer(String variable) {
        super(ImageContainer.class, forVariable(variable));
    }

    public QImageContainer(Path<? extends ImageContainer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImageContainer(PathMetadata metadata) {
        super(ImageContainer.class, metadata);
    }

}

