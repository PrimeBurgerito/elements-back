package com.elements.elementsapi.api.game.event.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.event.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends RealmDocumentRepository<Event> {
}
