package com.elements.elementsdomain.document.propertytemplate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStringPropertyTemplate is a Querydsl query type for StringPropertyTemplate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStringPropertyTemplate extends EntityPathBase<StringPropertyTemplate> {

    private static final long serialVersionUID = -1966950571L;

    public static final QStringPropertyTemplate stringPropertyTemplate = new QStringPropertyTemplate("stringPropertyTemplate");

    public final QPropertyTemplate _super = new QPropertyTemplate(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    //inherited
    public final StringPath key = _super.key;

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    //inherited
    public final StringPath name = _super.name;

    public final SetPath<String, StringPath> possibleValues = this.<String, StringPath>createSet("possibleValues", String.class, StringPath.class, PathInits.DIRECT2);

    //inherited
    public final StringPath realmId = _super.realmId;

    public final EnumPath<com.elements.elementsdomain.shared.property.StringProperty.StringPropertyType> type = createEnum("type", com.elements.elementsdomain.shared.property.StringProperty.StringPropertyType.class);

    public final ListPath<String, StringPath> value = this.<String, StringPath>createList("value", String.class, StringPath.class, PathInits.DIRECT2);

    public QStringPropertyTemplate(String variable) {
        super(StringPropertyTemplate.class, forVariable(variable));
    }

    public QStringPropertyTemplate(Path<? extends StringPropertyTemplate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStringPropertyTemplate(PathMetadata metadata) {
        super(StringPropertyTemplate.class, metadata);
    }

}

