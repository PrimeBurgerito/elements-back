package com.elements.elementsapi.api.statistic.repository;

import com.elements.elementsdomain.statistic.Objective;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends MongoRepository<Objective, String> {
}
