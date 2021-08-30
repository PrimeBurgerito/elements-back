package com.elements.elementsapi.api.game.location.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.location.Location;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface LocationRepository extends RealmDocumentRepository<Location> {
    Set<Location> findByNameIn(Collection<String> names);

    boolean existsAllById(Collection<String> ids);
}
