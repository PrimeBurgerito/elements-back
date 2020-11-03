package com.elements.elementsapi.api.game.property.service;

import com.elements.elementsapi.api.game.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.game.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.game.property.repository.NumericPropertyRepository;
import com.elements.elementsapi.api.game.property.service.mapper.NumericPropertyMapper;
import com.elements.elementsapi.api.game.property.service.resource.NumericPropertyDto;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import com.elements.elementsdomain.gamestate.GameState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NumericPropertyService extends BaseService<NumericPropertyDto, NumericPropertyTemplate> {

    private final NumericPropertyRepository repository;
    private final NumericPropertyMapper mapper;
    private final CharacterTemplateRepository characterTemplateRepository;
    private final GameStateRepository gameStateRepository;

    @Override
    public NumericPropertyRepository getRepository() {
        return repository;
    }

    @Override
    protected NumericPropertyMapper getMapper() {
        return mapper;
    }

    @Override
    public NumericPropertyTemplate create(NumericPropertyDto entityDto) {
        NumericPropertyTemplate property = super.create(entityDto);

        updateCharacterTemplates(property);
        updateGameStates(property);

        return property;
    }

    private void updateGameStates(NumericPropertyTemplate property) {
        List<GameState> gameStates = gameStateRepository.findAll();
        gameStates.forEach(state -> state.getCharacter().getProperties().getNumericProperties().add(property.toProperty()));
        gameStateRepository.saveAll(gameStates);
    }

    private void updateCharacterTemplates(NumericPropertyTemplate property) {
        List<CharacterTemplate> templates = characterTemplateRepository.findAll();
        templates.forEach(template -> template.getProperties().getNumericProperties().add(property.toProperty()));
        characterTemplateRepository.saveAll(templates);
    }
}
