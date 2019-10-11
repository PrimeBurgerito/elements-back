package com.elements.gamesession.util.querybuilder.requirement;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;
import java.util.Map.Entry;

import static java.lang.String.format;
import static org.springframework.data.mongodb.core.query.Criteria.where;

class AttributeCriteriaBuilder {

    private static final String ATTRIBUTES = "requirement.attributes";

    private AttributeCriteriaBuilder() {
    }

    static Criteria build(Map<String, Float> attributes) {
        return new Criteria().orOperator(where(ATTRIBUTES).is(null), buildAttributesCriteria(attributes));
    }

    private static Criteria buildAttributesCriteria(Map<String, Float> attributes) {
        return new Criteria().andOperator(attributes.entrySet().stream()
                .map(AttributeCriteriaBuilder::buildAttributeCriteria)
                .toArray(Criteria[]::new));
    }

    private static Criteria buildAttributeCriteria(Entry<String, Float> keyToValue) {
        String attributeKey = format("%s.%s", ATTRIBUTES, keyToValue.getKey());
        Criteria inRangeCriteria = where("first").lte(keyToValue.getValue()).and("second").gte(keyToValue.getValue());
        return new Criteria().orOperator(
                where(attributeKey).is(null),
                where(attributeKey).elemMatch(inRangeCriteria)
        );
    }
}
