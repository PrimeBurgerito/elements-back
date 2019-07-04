package com.elements.elementsapi.api.event.service.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageToSceneMap {
    @NonNull
    private int imageIndex;
    @NonNull
    private int sceneIndex;
}
