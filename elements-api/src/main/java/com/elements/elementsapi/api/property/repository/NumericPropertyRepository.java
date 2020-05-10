package com.elements.elementsapi.api.property.repository;

import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface NumericPropertyRepository extends MongoRepository<NumericPropertyTemplate, String> {
    List<NumericPropertyTemplate> findAllByKey(Collection<String> keys);
}
