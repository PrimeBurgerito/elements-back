package com.elements.elementsdomain.shared.character;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCharacter is a Querydsl query type for Character
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QCharacter extends BeanPath<Character> {

    private static final long serialVersionUID = -1503474140L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCharacter character = new QCharacter("character");

    public final SimplePath<CharacterEquipment> equipment = createSimple("equipment", CharacterEquipment.class);

    public final MapPath<String, com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage> images = this.<String, com.elements.elementsdomain.shared.image.Image, com.elements.elementsdomain.shared.image.QImage>createMap("images", String.class, com.elements.elementsdomain.shared.image.Image.class, com.elements.elementsdomain.shared.image.QImage.class);

    public final ListPath<com.elements.elementsdomain.document.item.Item, com.elements.elementsdomain.document.item.QItem> items = this.<com.elements.elementsdomain.document.item.Item, com.elements.elementsdomain.document.item.QItem>createList("items", com.elements.elementsdomain.document.item.Item.class, com.elements.elementsdomain.document.item.QItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QCharacterProperties properties;

    public final StringPath templateId = createString("templateId");

    public QCharacter(String variable) {
        this(Character.class, forVariable(variable), INITS);
    }

    public QCharacter(Path<? extends Character> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCharacter(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCharacter(PathMetadata metadata, PathInits inits) {
        this(Character.class, metadata, inits);
    }

    public QCharacter(Class<? extends Character> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.properties = inits.isInitialized("properties") ? new QCharacterProperties(forProperty("properties")) : null;
    }

}

