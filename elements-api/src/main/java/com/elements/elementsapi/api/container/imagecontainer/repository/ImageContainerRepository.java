package com.elements.elementsapi.api.container.imagecontainer.repository;

import com.elements.elementsdomain.document.container.ImageContainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ImageContainerRepository extends MongoRepository<ImageContainer, String> {
    ImageContainer findByKey(String key);

    List<ImageContainer> findByKeyIn(Set<String> key);
}
