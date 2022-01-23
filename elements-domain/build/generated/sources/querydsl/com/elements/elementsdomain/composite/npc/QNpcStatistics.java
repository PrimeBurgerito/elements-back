package com.elements.elementsdomain.composite.npc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNpcStatistics is a Querydsl query type for NpcStatistics
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QNpcStatistics extends BeanPath<NpcStatistics> {

    private static final long serialVersionUID = -1889613497L;

    public static final QNpcStatistics npcStatistics = new QNpcStatistics("npcStatistics");

    public final MapPath<String, Float, NumberPath<Float>> attributes = this.<String, Float, NumberPath<Float>>createMap("attributes", String.class, Float.class, NumberPath.class);

    public final MapPath<String, String, StringPath> properties = this.<String, String, StringPath>createMap("properties", String.class, String.class, StringPath.class);

    public QNpcStatistics(String variable) {
        super(NpcStatistics.class, forVariable(variable));
    }

    public QNpcStatistics(Path<? extends NpcStatistics> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNpcStatistics(PathMetadata metadata) {
        super(NpcStatistics.class, metadata);
    }

}

