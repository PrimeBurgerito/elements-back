package com.elements.elementsdomain.document.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWeapon is a Querydsl query type for Weapon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWeapon extends EntityPathBase<Weapon> {

    private static final long serialVersionUID = 193130125L;

    public static final QWeapon weapon = new QWeapon("weapon");

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

    public final EnumPath<Weapon.WeaponType> weaponType = createEnum("weaponType", Weapon.WeaponType.class);

    public QWeapon(String variable) {
        super(Weapon.class, forVariable(variable));
    }

    public QWeapon(Path<? extends Weapon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWeapon(PathMetadata metadata) {
        super(Weapon.class, metadata);
    }

}

