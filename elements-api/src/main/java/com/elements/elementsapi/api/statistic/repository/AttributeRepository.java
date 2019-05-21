package com.elements.elementsapi.api.statistic.repository;

import com.elements.elementsdomain.statistic.Attribute;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends MongoRepository<Attribute, String> {
}
