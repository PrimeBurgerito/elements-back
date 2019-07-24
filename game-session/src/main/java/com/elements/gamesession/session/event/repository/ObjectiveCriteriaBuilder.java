package com.elements.gamesession.session.event.repository;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

class ObjectiveCriteriaBuilder {

    private static final String OBJECTIVES_KEY = "requirement.objectives";

    private ObjectiveCriteriaBuilder() {
    }

    static Criteria build(List<String> objectives) {
        return new Criteria().orOperator(
                where(OBJECTIVES_KEY).is(null),
                where(OBJECTIVES_KEY).all(objectives)
        );
    }
}
