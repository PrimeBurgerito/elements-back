package com.elements.elementsapi.api.game.event.service.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageToSceneMap {
    @NonNull
    private Integer imageIndex;
    @NonNull
    private Integer sceneIndex;
}
