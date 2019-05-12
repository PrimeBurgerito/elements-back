package com.elements.elementsapi.api.gamestate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.gamestate.service.resource.GameStateDto;
import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.character.CharacterTemplate;
import com.elements.elementsdomain.gamestate.CharacterStatistics;
import com.elements.elementsdomain.gamestate.GameState;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GameStateService {

    private final GameStateRepository gameStateRepository;
    private final CharacterTemplateRepository characterTemplateRepository;

    public boolean create(GameStateDto gameStateDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CharacterTemplate characterTemplate = characterTemplateRepository
                .findById(gameStateDto.getCharacterTemplateId())
                .orElseThrow(() -> new RuntimeException("Character template not found"));

        GameState gameState = new GameState();
        gameState.setUserId(user.getId());
        gameState.setCharacterTemplateId(gameStateDto.getCharacterTemplateId());
        CharacterStatistics characterStatistics = CharacterStatistics.builder()
                .attributes(characterTemplate.getAttributes())
                .properties(characterTemplate.getProperties())
                .build();
        gameState.setCharacterStatistics(characterStatistics);

        gameStateRepository.save(gameState);
        return true;
    }
}
