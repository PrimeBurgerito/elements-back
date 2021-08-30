package com.elements.elementsapi.api.game.objective.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.objective.Objective;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectiveRepository extends RealmDocumentRepository<Objective> {
}
