package com.elements.elementsapi.api.game.gamestate.repository;

import com.elements.elementsdomain.gamestate.GameState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStateRepository extends MongoRepository<GameState, String> {
}
