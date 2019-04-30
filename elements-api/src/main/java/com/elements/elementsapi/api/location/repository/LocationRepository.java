package com.elements.elementsapi.api.location.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.elements.elementsapi.api.location.domain.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ArangoRepository<Location, String> {
}
