package com.elements.gamesession.util.querybuilder.requirement;

import com.elements.elementsdomain.document.event.QEvent;
import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Set;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.querydsl.QuerydslUtils.toDotPath;

@UtilityClass
class ObjectiveCriteriaBuilder {
    private final String OBJECTIVES_KEY = toDotPath(QEvent.event.requirement.objectives);

    Criteria build(Set<String> objectives) {
        return new Criteria().orOperator(
                where(OBJECTIVES_KEY).is(null),
                where(OBJECTIVES_KEY).all(objectives)
        );
    }
}
