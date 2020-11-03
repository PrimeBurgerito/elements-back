package com.elements.elementsapi.api.game.container.imagecontainer.service.resource;

import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import lombok.Data;

import java.util.Set;

@Data
public class ImageContainerDto {
    private String key;
    private Set<ImageDto> images;
}
