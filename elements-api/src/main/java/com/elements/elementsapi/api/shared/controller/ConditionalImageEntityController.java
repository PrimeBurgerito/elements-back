package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.ConditionalImageEntityService;
import com.elements.elementsapi.api.shared.service.resource.ConditionalImageDto;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.Image;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

public abstract class ConditionalImageEntityController<D, T extends DocumentBase> extends BaseController<D, T> {

    @Override
    protected abstract ConditionalImageEntityService<D, T> getService();

    @PutMapping(value = "/image/{entityId}/{imageKey}")
    Image addImage(@Valid ConditionalImageDto imageDto, @RequestParam MultipartFile file) {
        return getService().addImage(imageDto, file);
    }

    @DeleteMapping(value = "/image/{entityId}/{imageKey}")
    boolean removeImage(@PathVariable String entityId, @PathVariable String imageKey) {
        return getService().removeImage(entityId, imageKey);
    }
}
