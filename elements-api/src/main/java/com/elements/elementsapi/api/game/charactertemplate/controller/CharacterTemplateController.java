package com.elements.elementsapi.api.game.charactertemplate.controller;

import com.elements.elementsapi.api.game.charactertemplate.service.CharacterTemplateService;
import com.elements.elementsapi.api.game.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.shared.controller.ImageEntityController;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/character-template")
public class CharacterTemplateController extends ImageEntityController<CharacterTemplateDto, CharacterTemplate> {

    private final CharacterTemplateService service;

    @Override
    protected CharacterTemplateService getService() {
        return service;
    }

    @GetMapping("/full")
    public List<CharacterTemplate> findTemplates() {
        return service.findTemplates();
    }
}
