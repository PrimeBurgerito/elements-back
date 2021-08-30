package com.elements.elementsapi.api.game.container.imagecontainer.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.container.ImageContainer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ImageContainerRepository extends RealmDocumentRepository<ImageContainer> {
    ImageContainer findByKey(String key);

    List<ImageContainer> findByKeyIn(Set<String> key);
}
