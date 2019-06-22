package com.elements.elementsapi.api.gamestate.controller;

import com.elements.elementsapi.api.gamestate.service.GameStateService;
import com.elements.elementsapi.api.gamestate.service.resource.GameStateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/game-state")
public class GameStateController {

    private final GameStateService gameStateService;

    @PostMapping
    public boolean create(@RequestBody GameStateDto gameStateDto) {
        return gameStateService.create(gameStateDto);
    }
}
