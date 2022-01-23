package com.elements.elementsdomain.gamestate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameState is a Querydsl query type for GameState
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameState extends EntityPathBase<GameState> {

    private static final long serialVersionUID = 1891564999L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameState gameState = new QGameState("gameState");

    public final com.elements.elementscommon.domain.QDocumentBase _super = new com.elements.elementscommon.domain.QDocumentBase(this);

    public final com.elements.elementsdomain.shared.character.QCharacter character;

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath locationId = createString("locationId");

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath userId = createString("userId");

    public QGameState(String variable) {
        this(GameState.class, forVariable(variable), INITS);
    }

    public QGameState(Path<? extends GameState> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameState(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameState(PathMetadata metadata, PathInits inits) {
        this(GameState.class, metadata, inits);
    }

    public QGameState(Class<? extends GameState> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.character = inits.isInitialized("character") ? new com.elements.elementsdomain.shared.character.QCharacter(forProperty("character"), inits.get("character")) : null;
    }

}

