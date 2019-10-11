package com.elements.gamesession.util.querybuilder.requirement;

import com.elements.elementsdomain.aggregate.gamestate.GameState;
import com.elements.elementsdomain.composite.character.CharacterStatistics;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static java.util.Collections.emptySet;
import static java.util.Optional.ofNullable;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class RequirementQueryBuilder {
    private static final String LOCATION_ID = "requirement.locationId";

    public static Query build(GameState gameState) {
        CharacterStatistics statistics = gameState.getCharacter().getStatistics();
        return query(new Criteria().andOperator(
                where(LOCATION_ID).is(gameState.getLocationId()),
                AttributeCriteriaBuilder.build(statistics.getAttributes()),
                PropertyCriteriaBuilder.build(statistics.getProperties()),
                ObjectiveCriteriaBuilder.build(ofNullable(statistics.getObjectives()).orElse(emptySet()))
        ));
    }
}
