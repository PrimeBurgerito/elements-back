package com.elements.elementsapi.api.game.charactertemplate.controller;

import com.elements.elementsapi.api.game.charactertemplate.service.CharacterTemplateService;
import com.elements.elementsapi.api.game.charactertemplate.service.resource.CharacterTemplateDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentImageController;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/character-template")
public class CharacterTemplateController extends RealmDocumentImageController<CharacterTemplateDto, CharacterTemplate> {
    @GetMapping("/full")
    public List<CharacterTemplate> findTemplates(@RequestParam(required = false) String realmId) {
        return ((CharacterTemplateService) service).findTemplates(realmId);
    }
}
