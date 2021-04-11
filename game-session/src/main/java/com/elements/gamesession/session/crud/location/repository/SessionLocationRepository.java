package com.elements.gamesession.session.crud.location.repository;

import com.elements.elementsdomain.document.location.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionLocationRepository extends MongoRepository<Location, String>, QuerydslPredicateExecutor<Location> {
}
