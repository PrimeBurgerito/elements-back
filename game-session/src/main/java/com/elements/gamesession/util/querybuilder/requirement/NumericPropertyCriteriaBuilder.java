package com.elements.gamesession.util.querybuilder.requirement;

import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@UtilityClass
class NumericPropertyCriteriaBuilder {

    private final String ATTRIBUTES = "requirement.properties.numericProperties";

    Criteria build(Map<String, Float> numericProperties) {
        return new Criteria().orOperator(where(ATTRIBUTES).is(null), buildAttributesCriteria(numericProperties));
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
