package com.elements.elementsdomain.document.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClothing is a Querydsl query type for Clothing
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClothing extends EntityPathBase<Clothing> {

    private static final long serialVersionUID = -1555128391L;

    public static final QClothing clothing = new QClothing("clothing");

    public final QItem _super = new QItem(this);

    public final EnumPath<Clothing.ClothingType> clothingType = createEnum("clothingType", Clothing.ClothingType.class);

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

    public QClothing(String variable) {
        super(Clothing.class, forVariable(variable));
    }

    public QClothing(Path<? extends Clothing> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClothing(PathMetadata metadata) {
        super(Clothing.class, metadata);
    }

}

