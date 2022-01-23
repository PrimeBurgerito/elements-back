package com.elements.elementsdomain.document.event;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = 933766972L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEvent event = new QEvent("event");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath realmId = _super.realmId;

    public final com.elements.elementsdomain.shared.requirement.QRequirement requirement;

    public final ListPath<com.elements.elementsdomain.document.event.scene.SceneBase, com.elements.elementsdomain.document.event.scene.QSceneBase> scenes = this.<com.elements.elementsdomain.document.event.scene.SceneBase, com.elements.elementsdomain.document.event.scene.QSceneBase>createList("scenes", com.elements.elementsdomain.document.event.scene.SceneBase.class, com.elements.elementsdomain.document.event.scene.QSceneBase.class, PathInits.DIRECT2);

    public QEvent(String variable) {
        this(Event.class, forVariable(variable), INITS);
    }

    public QEvent(Path<? extends Event> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEvent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEvent(PathMetadata metadata, PathInits inits) {
        this(Event.class, metadata, inits);
    }

    public QEvent(Class<? extends Event> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.requirement = inits.isInitialized("requirement") ? new com.elements.elementsdomain.shared.requirement.QRequirement(forProperty("requirement"), inits.get("requirement")) : null;
    }

}

