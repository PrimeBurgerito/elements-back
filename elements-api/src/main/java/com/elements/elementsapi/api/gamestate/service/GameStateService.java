package com.elements.elementsapi.api.gamestate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.gamestate.service.resource.GameStateDto;
import com.elements.elementsapi.api.user.UserRepository;
import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.character.CharacterTemplate;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.gamestate.character.Character;
import com.elements.elementsdomain.gamestate.character.CharacterStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GameStateService {

    private final GameStateRepository gameStateRepository;
    private final UserRepository userRepository;
    private final CharacterTemplateRepository characterTemplateRepository;

    public boolean create(GameStateDto gameStateDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
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
        Character character = Character.builder()
                .name(gameStateDto.getCharacterName())
                .statistics(characterStatistics)
                .images(characterTemplate.getImages())
                .build();

        gameState.setCharacter(character);

        gameStateRepository.save(gameState);
        return true;
    }
}
