package com.elements.elementsapi.api.game.property.service;

import com.elements.elementsapi.api.game.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.game.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.game.property.repository.StringPropertyRepository;
import com.elements.elementsapi.api.game.property.service.mapper.StringPropertyMapper;
import com.elements.elementsapi.api.game.property.service.resource.StringPropertyDto;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import com.elements.elementsdomain.gamestate.GameState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StringPropertyService extends BaseService<StringPropertyDto, StringPropertyTemplate> {

    private final StringPropertyRepository repository;
    private final StringPropertyMapper mapper;
    private final CharacterTemplateRepository characterTemplateRepository;
    private final GameStateRepository gameStateRepository;

    @Override
    public StringPropertyRepository getRepository() {
        return repository;
    }

    @Override
    protected StringPropertyMapper getMapper() {
        return mapper;
    }

    @Override
    public StringPropertyTemplate create(StringPropertyDto entityDto) {
        StringPropertyTemplate property = super.create(entityDto);

        updateCharacterTemplates(property);
        updateGameStates(property);

        return property;
    }

    private void updateGameStates(StringPropertyTemplate property) {
        List<GameState> gameStates = gameStateRepository.findAll();
        gameStates.forEach(state -> state.getCharacter().getProperties().getStringProperties().add(property.toProperty()));
        gameStateRepository.saveAll(gameStates);
    }

    private void updateCharacterTemplates(StringPropertyTemplate property) {
        List<CharacterTemplate> templates = characterTemplateRepository.findAll();
        templates.forEach(template -> template.getProperties().getStringProperties().add(property.toProperty()));
        characterTemplateRepository.saveAll(templates);
    }
}
