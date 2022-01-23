package com.elements.elementsdomain.document.event.scene;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSceneBase is a Querydsl query type for SceneBase
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QSceneBase extends BeanPath<SceneBase> {

    private static final long serialVersionUID = -289549123L;

    public static final QSceneBase sceneBase = new QSceneBase("sceneBase");

    public final EnumPath<SceneType> type = createEnum("type", SceneType.class);

    public QSceneBase(String variable) {
        super(SceneBase.class, forVariable(variable));
    }

    public QSceneBase(Path<? extends SceneBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSceneBase(PathMetadata metadata) {
        super(SceneBase.class, metadata);
    }

}

