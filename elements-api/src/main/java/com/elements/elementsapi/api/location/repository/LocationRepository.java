package com.elements.elementsapi.api.location.repository;

import com.elements.elementsdomain.location.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    Location findByName(String name);

    Set<Location> findByNameIn(Collection<String> names);
}
