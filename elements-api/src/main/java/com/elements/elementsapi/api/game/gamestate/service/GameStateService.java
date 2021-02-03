package com.elements.elementsapi.api.game.gamestate.service;

import com.elements.elementsapi.api.game.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.game.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.game.gamestate.service.resource.GameStateDto;
import com.elements.elementsapi.api.game.location.repository.LocationRepository;
import com.elements.elementsapi.api.system.user.UserRepository;
import com.elements.elementscommon.domain.user.User;
import com.elements.elementsdomain.document.charactertemplate.CharacterTemplate;
import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.gamestate.GameState;
import com.elements.elementsdomain.shared.character.Character;
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
    private final LocationRepository locationRepository;

    public boolean create(GameStateDto gameStateDto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        CharacterTemplate characterTemplate = characterTemplateRepository
                .findById(gameStateDto.getCharacterTemplateId())
                .orElseThrow(() -> new RuntimeException("Character template not found"));

        Character character = Character.builder()
                .name(gameStateDto.getCharacterName())
                .properties(characterTemplate.getProperties())
                .templateId(characterTemplate.getId())
                .images(characterTemplate.getImages())
                .build();

        Location location = locationRepository.findAll().get(0);

        gameStateRepository.save(GameState.builder()
                .userId(user.getId())
                .locationId(location.getId())
                .character(character)
                .build());
        return true;
    }
}
