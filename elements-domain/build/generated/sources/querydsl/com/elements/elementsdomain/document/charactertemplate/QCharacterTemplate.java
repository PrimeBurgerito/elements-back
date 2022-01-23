package com.elements.elementsdomain.document.charactertemplate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCharacterTemplate is a Querydsl query type for CharacterTemplate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCharacterTemplate extends EntityPathBase<CharacterTemplate> {

    private static final long serialVersionUID = -2131927250L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCharacterTemplate characterTemplate = new QCharacterTemplate("characterTemplate");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final MapPath<String, com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage> images = this.<String, com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage>createMap("images", String.class, com.elements.elementsdomain.shared.image.Image.class, com.elements.elementsdomain.shared.image.QImage.class);

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final com.elements.elementsdomain.shared.character.QCharacterProperties properties;

    //inherited
    public final StringPath realmId = _super.realmId;

    public QCharacterTemplate(String variable) {
        this(CharacterTemplate.class, forVariable(variable), INITS);
    }

    public QCharacterTemplate(Path<? extends CharacterTemplate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCharacterTemplate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCharacterTemplate(PathMetadata metadata, PathInits inits) {
        this(CharacterTemplate.class, metadata, inits);
    }

    public QCharacterTemplate(Class<? extends CharacterTemplate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.properties = inits.isInitialized("properties") ? new com.elements.elementsdomain.shared.character.QCharacterProperties(forProperty("properties")) : null;
    }

}

