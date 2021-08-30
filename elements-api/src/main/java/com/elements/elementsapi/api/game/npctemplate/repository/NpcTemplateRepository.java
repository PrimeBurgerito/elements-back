package com.elements.elementsapi.api.game.npctemplate.repository;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcTemplateRepository extends RealmDocumentRepository<NpcTemplate> {
}
