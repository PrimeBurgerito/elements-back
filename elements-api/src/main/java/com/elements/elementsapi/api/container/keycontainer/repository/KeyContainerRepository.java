package com.elements.elementsapi.api.container.keycontainer.repository;

import com.elements.elementsdomain.document.container.KeyContainer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;

public interface KeyContainerRepository extends MongoRepository<KeyContainer, String> {
    KeyContainer findByKey(String key);

    List<KeyContainer> findByKeyIn(Set<String> key);
}
