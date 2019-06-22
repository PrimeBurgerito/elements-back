package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.ImageEntityService;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.Image;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public abstract class ImageEntityController<D, T extends DocumentBase> extends BaseController<D, T> {

    @Override
    protected abstract ImageEntityService<D, T> getService();

    @PutMapping(value = "/image/{entityId}/{imageKey}")
    public Image addImage(@PathVariable String entityId, @PathVariable String imageKey, @RequestParam MultipartFile file) {
        return getService().addImage(entityId, imageKey, file);
    }

    @DeleteMapping(value = "/image/{entityId}/{imageKey}")
    public boolean removeImage(@PathVariable String entityId, @PathVariable String imageKey) {
        return getService().removeImage(entityId, imageKey);
    }
}
