package com.elements.gamesession.session.event.repository;

import com.elements.elementsdomain.aggregate.event.Event;
import com.elements.elementsdomain.aggregate.gamestate.GameState;
import com.elements.elementsdomain.composite.character.CharacterStatistics;
import com.elements.gamesession.util.querybuilder.requirement.RequirementQueryBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SessionEventRepositoryImpl implements SessionEventRepository {

    private final MongoTemplate template;

    @Override
    @Cacheable("eventQuery")
    public List<Event> findByLocationAndStatistics(String locationId, CharacterStatistics statistics) {
        return template.find(RequirementQueryBuilder.build(locationId, statistics), Event.class);
    }
}
