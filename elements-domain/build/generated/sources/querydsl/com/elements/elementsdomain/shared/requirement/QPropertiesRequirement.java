package com.elements.elementsdomain.shared.requirement;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPropertiesRequirement is a Querydsl query type for PropertiesRequirement
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPropertiesRequirement extends BeanPath<PropertiesRequirement> {

    private static final long serialVersionUID = -1206663899L;

    public static final QPropertiesRequirement propertiesRequirement = new QPropertiesRequirement("propertiesRequirement");

    public final MapPath<String, org.springframework.data.util.Pair<Float, Float>, org.springframework.data.util.QPair> numericProperties = this.<String, org.springframework.data.util.Pair<Float, Float>, org.springframework.data.util.QPair>createMap("numericProperties", String.class, org.springframework.data.util.Pair.class, org.springframework.data.util.QPair.class);

    public final MapPath<String, java.util.Set<String>, SimplePath<java.util.Set<String>>> stringProperties = this.<String, java.util.Set<String>, SimplePath<java.util.Set<String>>>createMap("stringProperties", String.class, java.util.Set.class, SimplePath.class);

    public QPropertiesRequirement(String variable) {
        super(PropertiesRequirement.class, forVariable(variable));
    }

    public QPropertiesRequirement(Path<? extends PropertiesRequirement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPropertiesRequirement(PathMetadata metadata) {
        super(PropertiesRequirement.class, metadata);
    }

}

