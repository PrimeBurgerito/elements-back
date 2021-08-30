package com.elements.elementsapi.api.game.container.imagecontainer.service.resource;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImageContainerDto extends RealmDocumentDto {
    private String key;
    private Set<ImageDto> images;
}
