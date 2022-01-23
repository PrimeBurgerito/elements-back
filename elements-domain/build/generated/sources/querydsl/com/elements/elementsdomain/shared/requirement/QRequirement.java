package com.elements.elementsdomain.shared.requirement;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRequirement is a Querydsl query type for Requirement
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QRequirement extends BeanPath<Requirement> {

    private static final long serialVersionUID = -1720648040L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRequirement requirement = new QRequirement("requirement");

    public final ListPath<String, StringPath> locationIds = this.<String, StringPath>createList("locationIds", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<String, StringPath> objectives = this.<String, StringPath>createList("objectives", String.class, StringPath.class, PathInits.DIRECT2);

    public final QPropertiesRequirement properties;

    public final SimplePath<Timing> timing = createSimple("timing", Timing.class);

    public QRequirement(String variable) {
        this(Requirement.class, forVariable(variable), INITS);
    }

    public QRequirement(Path<? extends Requirement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRequirement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRequirement(PathMetadata metadata, PathInits inits) {
        this(Requirement.class, metadata, inits);
    }

    public QRequirement(Class<? extends Requirement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.properties = inits.isInitialized("properties") ? new QPropertiesRequirement(forProperty("properties")) : null;
    }

}

