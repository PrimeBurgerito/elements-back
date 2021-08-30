package com.elements.elementsapi.api.game.charactertemplate.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterTemplateRepository extends RealmDocumentRepository<CharacterTemplate> {
}
