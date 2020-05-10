package com.elements.elementsapi.api.charactertemplate.repository;

import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterTemplateRepository extends MongoRepository<CharacterTemplate, String> {
}
