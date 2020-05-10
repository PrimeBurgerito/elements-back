package com.elements.elementsapi.api.gamestate.service;

import com.elements.elementsapi.api.charactertemplate.repository.CharacterTemplateRepository;
import com.elements.elementsapi.api.gamestate.repository.GameStateRepository;
import com.elements.elementsapi.api.gamestate.service.resource.GameStateDto;
import com.elements.elementsapi.api.location.repository.LocationRepository;
import com.elements.elementsapi.api.user.UserRepository;
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
                .images(characterTemplate.getImages())
                .templateId(characterTemplate.getId())
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
