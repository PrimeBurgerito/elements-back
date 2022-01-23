package com.elements.elementsdomain.document.location.area;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocationInfo is a Querydsl query type for LocationInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QLocationInfo extends BeanPath<LocationInfo> {

    private static final long serialVersionUID = -1690451947L;

    public static final QLocationInfo locationInfo = new QLocationInfo("locationInfo");

    public final StringPath id = createString("id");

    public final SimplePath<com.mongodb.client.model.geojson.Point> position = createSimple("position", com.mongodb.client.model.geojson.Point.class);

    public QLocationInfo(String variable) {
        super(LocationInfo.class, forVariable(variable));
    }

    public QLocationInfo(Path<? extends LocationInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocationInfo(PathMetadata metadata) {
        super(LocationInfo.class, metadata);
    }

}

