package com.elements.gamesession.session.event.repository;

import com.elements.elementsdomain.aggregate.event.Event;
import com.elements.elementsdomain.aggregate.gamestate.GameState;
import com.elements.gamesession.util.querybuilder.requirement.RequirementQueryBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SessionEventRepositoryImpl implements SessionEventRepository {

    private final MongoTemplate template;

    @Override
    public List<Event> findByGameState(GameState gameState) {
        return template.find(RequirementQueryBuilder.build(gameState), Event.class);
    }
}
