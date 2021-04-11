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
    private final Criteria IS_NULL = where(OBJECTIVES_KEY).is(null);

    Criteria build(Set<String> objectives) {
        if (objectives == null || objectives.isEmpty()) {
            return IS_NULL;
        }
        return new Criteria().orOperator(IS_NULL, where(OBJECTIVES_KEY).all(objectives));
    }
}
