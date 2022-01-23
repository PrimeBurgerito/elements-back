package org.springframework.data.util;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPair is a Querydsl query type for Pair
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPair extends BeanPath<Pair<?, ?>> {

    private static final long serialVersionUID = 905022825L;

    public static final QPair pair = new QPair("pair");

    public final SimplePath<Object> first = createSimple("first", Object.class);

    public final SimplePath<Object> second = createSimple("second", Object.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPair(String variable) {
        super((Class) Pair.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPair(Path<Pair> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPair(PathMetadata metadata) {
        super((Class) Pair.class, metadata);
    }

}

