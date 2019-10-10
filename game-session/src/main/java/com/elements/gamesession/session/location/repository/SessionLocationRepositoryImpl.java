package com.elements.gamesession.session.location.repository;

import com.elements.elementsdomain.aggregate.location.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class SessionLocationRepositoryImpl implements SessionLocationRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Location get(String locationId) {
        return mongoTemplate.findById(locationId, Location.class);
    }

    @Override
    public Location getByName(String locationName) {
        return mongoTemplate.findOne(query(where("name").is(locationName)), Location.class);
    }
}
