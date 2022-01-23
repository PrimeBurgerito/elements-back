package com.elements.elementsdomain.shared.image;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QConditionalImage is a Querydsl query type for ConditionalImage
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QConditionalImage extends BeanPath<ConditionalImage> {

    private static final long serialVersionUID = 1658132264L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QConditionalImage conditionalImage = new QConditionalImage("conditionalImage");

    public final QImage image;

    public final com.elements.elementsdomain.shared.requirement.QRequirement requirement;

    public QConditionalImage(String variable) {
        this(ConditionalImage.class, forVariable(variable), INITS);
    }

    public QConditionalImage(Path<? extends ConditionalImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QConditionalImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QConditionalImage(PathMetadata metadata, PathInits inits) {
        this(ConditionalImage.class, metadata, inits);
    }

    public QConditionalImage(Class<? extends ConditionalImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.image = inits.isInitialized("image") ? new QImage(forProperty("image")) : null;
        this.requirement = inits.isInitialized("requirement") ? new com.elements.elementsdomain.shared.requirement.QRequirement(forProperty("requirement"), inits.get("requirement")) : null;
    }

}

