package com.elements.elementsapi.api.game.npctemplate.repository;

import com.elements.elementsdomain.document.npc.NpcTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcTemplateRepository extends MongoRepository<NpcTemplate, String> {
}
