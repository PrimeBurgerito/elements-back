package com.elements.gamesession.session.crud.event.repository;

import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.shared.character.CharacterProperties;
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
    public List<Event> findByLocationAndProperties(String locationId, CharacterProperties statistics) {
        return template.find(RequirementQueryBuilder.build(locationId, statistics), Event.class);
    }
}
