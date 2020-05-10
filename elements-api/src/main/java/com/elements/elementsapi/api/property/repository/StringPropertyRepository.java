package com.elements.elementsapi.api.property.repository;

import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StringPropertyRepository extends MongoRepository<StringPropertyTemplate, String> {
    List<StringPropertyTemplate> findByKeyIn(Collection<String> keys);
}
