package com.elements.gamesession.util.querybuilder.requirement;

import com.elements.elementsdomain.document.event.QEvent;
import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.querydsl.QuerydslUtils.toDotPath;

@UtilityClass
class StringPropertyCriteriaBuilder {
    private final String PROPERTIES_KEY = toDotPath(QEvent.event.requirement.properties.stringProperties);

    Criteria build(Map<String, List<String>> properties) {
        return new Criteria().orOperator(where(PROPERTIES_KEY).is(null), buildPropertiesCriteria(properties));
    }

    private Criteria buildPropertiesCriteria(Map<String, List<String>> properties) {
        return new Criteria().andOperator(properties.entrySet().stream()
                .map(StringPropertyCriteriaBuilder::buildPropertyCriteria)
                .toArray(Criteria[]::new)
        );
    }

    private Criteria buildPropertyCriteria(Entry<String, List<String>> keyToValue) {
        String propertyKey = format("%s.%s", PROPERTIES_KEY, keyToValue.getKey());
        return new Criteria().orOperator(
                where(propertyKey).is(null),
                where(propertyKey).all(keyToValue.getValue())
        );
    }
}
