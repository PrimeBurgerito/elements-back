package com.elements.gamesession.util.querybuilder.requirement;

import com.elements.elementsdomain.document.event.QEvent;
import com.elements.elementsdomain.shared.character.CharacterProperties;
import lombok.experimental.UtilityClass;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static java.util.Collections.emptySet;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.querydsl.QuerydslUtils.toDotPath;

@UtilityClass
public class RequirementQueryBuilder {
    private final String LOCATION_IDS = toDotPath(QEvent.event.requirement.locationIds);

    public Query build(String locationId, CharacterProperties properties) {
        return query(new Criteria().andOperator(
                where(LOCATION_IDS).is(locationId),
                NumericPropertyCriteriaBuilder.build(properties.getNumericPropertyKeyToValue()),
                StringPropertyCriteriaBuilder.build(properties.getStringPropertyKeyToValue()),
                ObjectiveCriteriaBuilder.build(emptySet())
        ));
    }
}
