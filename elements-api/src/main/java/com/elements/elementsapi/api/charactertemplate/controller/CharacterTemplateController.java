package com.elements.elementsapi.api.charactertemplate.controller;

import com.elements.elementsapi.api.charactertemplate.service.CharacterTemplateService;
import com.elements.elementsapi.api.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.shared.controller.ImageEntityController;
import com.elements.elementsdomain.character.CharacterTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/character-template")
public class CharacterTemplateController extends ImageEntityController<CharacterTemplateDto, CharacterTemplate> {

    private final CharacterTemplateService service;

    @Override
    protected CharacterTemplateService getService() {
        return service;
    }
}
