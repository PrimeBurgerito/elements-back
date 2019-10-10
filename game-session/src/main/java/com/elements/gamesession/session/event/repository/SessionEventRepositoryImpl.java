package com.elements.gamesession.session.event.repository;

import com.elements.elementsdomain.composite.character.CharacterStatistics;
import com.elements.elementsdomain.aggregate.event.Event;
import com.elements.elementsdomain.aggregate.gamestate.GameState;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Collections.emptySet;
import static java.util.Optional.ofNullable;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class SessionEventRepositoryImpl implements SessionEventRepository {

    private static final String LOCATION_ID = "requirement.locationId";
    private final MongoTemplate template;

    @Override
    public List<Event> findByGameState(GameState gameState) {
        return template.find(eventQuery(gameState), Event.class);
    }

    private Query eventQuery(GameState gameState) {
        CharacterStatistics statistics = gameState.getCharacter().getStatistics();
        return query(new Criteria().andOperator(
                where(LOCATION_ID).is(gameState.getLocationId()),
                AttributeCriteriaBuilder.build(statistics.getAttributes()),
                PropertyCriteriaBuilder.build(statistics.getProperties()),
                ObjectiveCriteriaBuilder.build(ofNullable(statistics.getObjectives()).orElse(emptySet()))
        ));
    }
}
