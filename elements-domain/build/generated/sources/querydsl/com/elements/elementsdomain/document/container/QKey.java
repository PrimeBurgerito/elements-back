package com.elements.elementsdomain.document.container;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKey is a Querydsl query type for Key
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QKey extends BeanPath<Key> {

    private static final long serialVersionUID = 493119208L;

    public static final QKey key = new QKey("key");

    public final BooleanPath required = createBoolean("required");

    public final StringPath value = createString("value");

    public QKey(String variable) {
        super(Key.class, forVariable(variable));
    }

    public QKey(Path<? extends Key> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKey(PathMetadata metadata) {
        super(Key.class, metadata);
    }

}

