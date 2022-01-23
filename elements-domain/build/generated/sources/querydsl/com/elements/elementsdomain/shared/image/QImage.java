package com.elements.elementsdomain.shared.image;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QImage extends BeanPath<Image> {

    private static final long serialVersionUID = -1450753400L;

    public static final QImage image = new QImage("image");

    public final MapPath<String, ImageCrop, SimplePath<ImageCrop>> crops = this.<String, ImageCrop, SimplePath<ImageCrop>>createMap("crops", String.class, ImageCrop.class, SimplePath.class);

    public final StringPath fileName = createString("fileName");

    public final StringPath key = createString("key");

    public final StringPath uri = createString("uri");

    public QImage(String variable) {
        super(Image.class, forVariable(variable));
    }

    public QImage(Path<? extends Image> path) {
        super(path.getType(), path.getMetadata());
    }

    public QImage(PathMetadata metadata) {
        super(Image.class, metadata);
    }

}

