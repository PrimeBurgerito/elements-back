package com.elements.elementsapi.api.game.container.keycontainer.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.container.KeyContainer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface KeyContainerRepository extends RealmDocumentRepository<KeyContainer> {
    KeyContainer findByKey(String key);

    List<KeyContainer> findByKeyIn(Set<String> key);
}
