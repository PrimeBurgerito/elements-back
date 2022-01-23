package com.elements.elementsdomain.shared.character;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCharacterProperties is a Querydsl query type for CharacterProperties
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QCharacterProperties extends BeanPath<CharacterProperties> {

    private static final long serialVersionUID = -880682377L;

    public static final QCharacterProperties characterProperties = new QCharacterProperties("characterProperties");

    public final MapPath<String, com.elements.elementsdomain.shared.property.NumericProperty, SimplePath<com.elements.elementsdomain.shared.property.NumericProperty>> keyToNumericProperty = this.<String, com.elements.elementsdomain.shared.property.NumericProperty, SimplePath<com.elements.elementsdomain.shared.property.NumericProperty>>createMap("keyToNumericProperty", String.class, com.elements.elementsdomain.shared.property.NumericProperty.class, SimplePath.class);

    public final MapPath<String, com.elements.elementsdomain.shared.property.StringProperty, SimplePath<com.elements.elementsdomain.shared.property.StringProperty>> keyToStringProperty = this.<String, com.elements.elementsdomain.shared.property.StringProperty, SimplePath<com.elements.elementsdomain.shared.property.StringProperty>>createMap("keyToStringProperty", String.class, com.elements.elementsdomain.shared.property.StringProperty.class, SimplePath.class);

    public final ListPath<com.elements.elementsdomain.shared.property.NumericProperty, SimplePath<com.elements.elementsdomain.shared.property.NumericProperty>> numericProperties = this.<com.elements.elementsdomain.shared.property.NumericProperty, SimplePath<com.elements.elementsdomain.shared.property.NumericProperty>>createList("numericProperties", com.elements.elementsdomain.shared.property.NumericProperty.class, SimplePath.class, PathInits.DIRECT2);

    public final MapPath<String, Float, NumberPath<Float>> numericPropertyKeyToValue = this.<String, Float, NumberPath<Float>>createMap("numericPropertyKeyToValue", String.class, Float.class, NumberPath.class);

    public final ListPath<com.elements.elementsdomain.shared.property.StringProperty, SimplePath<com.elements.elementsdomain.shared.property.StringProperty>> stringProperties = this.<com.elements.elementsdomain.shared.property.StringProperty, SimplePath<com.elements.elementsdomain.shared.property.StringProperty>>createList("stringProperties", com.elements.elementsdomain.shared.property.StringProperty.class, SimplePath.class, PathInits.DIRECT2);

    public final MapPath<String, java.util.List<String>, SimplePath<java.util.List<String>>> stringPropertyKeyToValue = this.<String, java.util.List<String>, SimplePath<java.util.List<String>>>createMap("stringPropertyKeyToValue", String.class, java.util.List.class, SimplePath.class);

    public QCharacterProperties(String variable) {
        super(CharacterProperties.class, forVariable(variable));
    }

    public QCharacterProperties(Path<? extends CharacterProperties> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCharacterProperties(PathMetadata metadata) {
        super(CharacterProperties.class, metadata);
    }

}

