package com.elements.gamesession.session.crud.gamestate.repository;

import com.elements.elementsdomain.gamestate.GameState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameStateRepository extends MongoRepository<GameState, String> {
    List<GameState> findAllByUserId(String userId);
}
