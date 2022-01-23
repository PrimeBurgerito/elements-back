package com.elements.elementsdomain.document.propertytemplate;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPropertyTemplate is a Querydsl query type for PropertyTemplate
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPropertyTemplate extends BeanPath<PropertyTemplate<?, ? extends com.elements.elementsdomain.shared.property.Property<?>>> {

    private static final long serialVersionUID = 1347780836L;

    public static final QPropertyTemplate propertyTemplate = new QPropertyTemplate("propertyTemplate");

    public final com.elements.elementsdomain.document.QRealmDocument _super = new com.elements.elementsdomain.document.QRealmDocument(this);

    //inherited
    public final DateTimePath<java.time.Instant> created = _super.created;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath key = createString("key");

    //inherited
    public final DateTimePath<java.time.Instant> modified = _super.modified;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    //inherited
    public final StringPath realmId = _super.realmId;

    public final SimplePath<Object> value = createSimple("value", Object.class);

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPropertyTemplate(String variable) {
        super((Class) PropertyTemplate.class, forVariable(variable));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPropertyTemplate(Path<? extends PropertyTemplate> path) {
        super((Class) path.getType(), path.getMetadata());
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QPropertyTemplate(PathMetadata metadata) {
        super((Class) PropertyTemplate.class, metadata);
    }

}

