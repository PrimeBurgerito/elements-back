package com.elements.elementsapi.api.game.objective.repository;

import com.elements.elementsdomain.document.objective.Objective;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends MongoRepository<Objective, String> {
}
