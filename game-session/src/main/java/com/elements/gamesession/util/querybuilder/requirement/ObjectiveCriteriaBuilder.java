package com.elements.gamesession.util.querybuilder.requirement;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Set;

import static org.springframework.data.mongodb.core.query.Criteria.where;

class ObjectiveCriteriaBuilder {

    private static final String OBJECTIVES_KEY = "requirement.objectives";

    private ObjectiveCriteriaBuilder() {
    }

    static Criteria build(Set<String> objectives) {
        return new Criteria().orOperator(
                where(OBJECTIVES_KEY).is(null),
                where(OBJECTIVES_KEY).all(objectives)
        );
    }
}