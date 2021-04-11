package com.elements.gamesession.util.querybuilder.requirement;

import com.elements.elementsdomain.document.event.QEvent;
import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.querydsl.QuerydslUtils.toDotPath;


@UtilityClass
class NumericPropertyCriteriaBuilder {
    private final String ATTRIBUTES = toDotPath(QEvent.event.requirement.properties.numericProperties);
    private final Criteria IS_NULL = where(ATTRIBUTES).is(null);

    Criteria build(Map<String, Float> numericProperties) {
        if (numericProperties == null || numericProperties.isEmpty()) {
            return IS_NULL;
        }
        return new Criteria().orOperator(IS_NULL, buildAttributesCriteria(numericProperties));
    }

    private Criteria buildAttributesCriteria(Map<String, Float> attributes) {
        return new Criteria().andOperator(attributes.entrySet().stream()
                .map(NumericPropertyCriteriaBuilder::buildAttributeCriteria)
                .toArray(Criteria[]::new));
    }

    private Criteria buildAttributeCriteria(Entry<String, Float> keyToValue) {
        String attributeKey = format("%s.%s", ATTRIBUTES, keyToValue.getKey());
        Criteria inRangeCriteria = where("first").lte(keyToValue.getValue()).and("second").gte(keyToValue.getValue());
        return new Criteria().orOperator(
                where(attributeKey).is(null),
                where(attributeKey).elemMatch(inRangeCriteria)
        );
    }
}
