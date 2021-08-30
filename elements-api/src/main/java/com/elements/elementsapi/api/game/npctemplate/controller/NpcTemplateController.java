package com.elements.elementsapi.api.game.npctemplate.controller;

import com.elements.elementsapi.api.game.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentConditionalImageController;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/npc-template")
public class NpcTemplateController extends RealmDocumentConditionalImageController<NpcTemplateDto, NpcTemplate> {
}
