package com.elements.elementsapi.api.npctemplate.repository;

import com.elements.elementsdomain.aggregate.npc.NpcTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NpcTemplateRepository extends MongoRepository<NpcTemplate, String> {
}
