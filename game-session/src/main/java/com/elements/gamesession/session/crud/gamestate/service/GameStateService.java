package com.elements.gamesession.session.crud.gamestate.service;

import com.elements.elementsdomain.gamestate.GameState;
import com.elements.gamesession.session.crud.gamestate.repository.GameStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GameStateService {
    private final GameStateRepository repository;

    @Transactional(readOnly = true)
    public GameState getForUser(String userId) {
        List<GameState> gameStates = repository.findAllByUserId(userId);
        if (gameStates == null || gameStates.isEmpty()) {
            throw new RuntimeException("No game states found for userId: " + userId);
        }
        return gameStates.get(0);
    }

    public void save(GameState gameState) {
        repository.save(gameState);
    }
}
