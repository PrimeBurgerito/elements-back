package com.elements.elementsapi.api.statistic.repository;

import com.elements.elementsdomain.aggregate.statistic.Objective;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends MongoRepository<Objective, String> {
}
