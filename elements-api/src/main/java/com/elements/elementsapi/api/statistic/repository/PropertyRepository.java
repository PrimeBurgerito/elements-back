package com.elements.elementsapi.api.statistic.repository;

import com.elements.elementsdomain.statistic.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String> {
}
