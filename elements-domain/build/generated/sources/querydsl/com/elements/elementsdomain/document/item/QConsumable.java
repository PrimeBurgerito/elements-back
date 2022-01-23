package com.elements.elementsdomain.document.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QConsumable is a Querydsl query type for Consumable
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QConsumable extends EntityPathBase<Consumable> {

    private static final long serialVersionUID = 1082976852L;

    public static final QConsumable consumable = new QConsumable("consumable");

    public final QItem _super = new QItem(this);

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

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath realmId = _super.realmId;

    public final EnumPath<ItemType> type = createEnum("type", ItemType.class);

    public QConsumable(String variable) {
        super(Consumable.class, forVariable(variable));
    }

    public QConsumable(Path<? extends Consumable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConsumable(PathMetadata metadata) {
        super(Consumable.class, metadata);
    }

}

