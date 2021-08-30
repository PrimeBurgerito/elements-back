package com.elements.elementsapi.api.game.property.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface NumericPropertyRepository extends RealmDocumentRepository<NumericPropertyTemplate> {
}
