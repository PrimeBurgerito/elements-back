package com.elements.gamesession.session.event.repository;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static org.springframework.data.mongodb.core.query.Criteria.where;

class PropertyCriteriaBuilder {

    private static final String PROPERTIES_KEY = "requirement.properties";

    private PropertyCriteriaBuilder() {
    }

    static Criteria build(Map<String, String> properties) {
        return new Criteria().orOperator(where(PROPERTIES_KEY).is(null), buildPropertiesCriteria(properties));
    }

    private static Criteria buildPropertiesCriteria(Map<String, String> properties) {
        return new Criteria().andOperator(properties.entrySet().stream()
                .map(PropertyCriteriaBuilder::buildPropertyCriteria)
                .toArray(Criteria[]::new)
        );
    }

    private static Criteria buildPropertyCriteria(Entry<String, String> keyToValue) {
        String propertyKey = format("%s.%s", PROPERTIES_KEY, keyToValue.getKey());
        return new Criteria().orOperator(
                where(propertyKey).is(null),
                where(propertyKey).all(keyToValue.getValue())
        );
    }
}
