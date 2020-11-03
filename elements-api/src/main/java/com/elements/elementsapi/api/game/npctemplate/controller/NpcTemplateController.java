package com.elements.elementsapi.api.game.npctemplate.controller;

import com.elements.elementsapi.api.game.npctemplate.service.NpcTemplateService;
import com.elements.elementsapi.api.game.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsapi.api.shared.controller.ConditionalImageEntityController;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/npc-template")
public class NpcTemplateController extends ConditionalImageEntityController<NpcTemplateDto, NpcTemplate> {

    private final NpcTemplateService service;

    @Override
    protected NpcTemplateService getService() {
        return service;
    }
}
