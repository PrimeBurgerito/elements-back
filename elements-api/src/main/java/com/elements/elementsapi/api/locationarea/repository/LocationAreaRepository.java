package com.elements.elementsapi.api.locationarea.repository;

import com.elements.elementsdomain.aggregate.location.area.LocationArea;
import com.elements.elementsdomain.aggregate.location.area.LocationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LocationAreaRepository extends MongoRepository<LocationArea, String> {
    boolean existsAllById(Set<String> ids);
}
