package com.elements.elementsapi.api.event.repository;

import com.elements.elementsdomain.document.event.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
