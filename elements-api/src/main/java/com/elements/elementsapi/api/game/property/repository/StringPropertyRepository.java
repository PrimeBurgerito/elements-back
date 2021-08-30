package com.elements.elementsapi.api.game.property.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface StringPropertyRepository extends RealmDocumentRepository<StringPropertyTemplate> {
}
