package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.ImageEntityService;
import com.elements.elementsapi.api.shared.service.resource.ImageDto;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.Image;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class ImageEntityController<D, T extends DocumentBase> extends BaseController<D, T> {

    @Override
    protected abstract ImageEntityService<D, T> getService();

    @PutMapping(value = "/image")
    public Image addImage(
            @RequestPart("imageDto") @Valid ImageDto imageDto,
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file
    ) {
        return getService().addImage(imageDto, file);
    }

    @DeleteMapping(value = "/image/{entityId}/{imageKey}")
    public boolean removeImage(@PathVariable String entityId, @PathVariable String imageKey) {
        return getService().removeImage(entityId, imageKey);
    }
}
