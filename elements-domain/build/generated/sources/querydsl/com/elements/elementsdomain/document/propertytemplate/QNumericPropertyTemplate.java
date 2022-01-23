package com.elements.elementsdomain.document.propertytemplate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNumericPropertyTemplate is a Querydsl query type for NumericPropertyTemplate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNumericPropertyTemplate extends EntityPathBase<NumericPropertyTemplate> {

    private static final long serialVersionUID = -1097098873L;

    public static final QNumericPropertyTemplate numericPropertyTemplate = new QNumericPropertyTemplate("numericPropertyTemplate");

    public final QPropertyTemplate _super = new QPropertyTemplate(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final StringPath key = _super.key;

    public final NumberPath<Float> max = createNumber("max", Float.class);

    public final NumberPath<Float> min = createNumber("min", Float.class);

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath realmId = _super.realmId;

    public final NumberPath<Float> value = createNumber("value", Float.class);

    public QNumericPropertyTemplate(String variable) {
        super(NumericPropertyTemplate.class, forVariable(variable));
    }

    public QNumericPropertyTemplate(Path<? extends NumericPropertyTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNumericPropertyTemplate(PathMetadata metadata) {
        super(NumericPropertyTemplate.class, metadata);
    }

}

