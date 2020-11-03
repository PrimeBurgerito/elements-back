package com.elements.elementsapi.api.game.locationarea.repository;

import com.elements.elementsdomain.document.location.area.LocationArea;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LocationAreaRepository extends MongoRepository<LocationArea, String> {
    boolean existsAllById(Set<String> ids);
}
