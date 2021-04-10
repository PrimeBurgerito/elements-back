package com.elements.gamesession.session.crud.event.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SceneStateOptionDTO {
    private final String text;
    private final boolean disabled;
}
