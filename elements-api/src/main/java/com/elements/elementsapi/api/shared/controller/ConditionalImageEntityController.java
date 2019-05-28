package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.ConditionalImageEntityService;
import com.elements.elementsapi.api.shared.service.resource.ConditionalImageDto;
import com.elements.elementscommon.domain.DocumentBase;
import com.elements.elementsdomain.image.ConditionalImage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class ConditionalImageEntityController<D, T extends DocumentBase> extends BaseController<D, T> {

    @Override
    protected abstract ConditionalImageEntityService<D, T> getService();

    @PutMapping(value = "/image", consumes = {"multipart/form-data"})
    ConditionalImage addImage(
            @RequestPart("imageDto") @Valid ConditionalImageDto imageDto,
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file
    ) {
        return getService().addImage(imageDto, file);
    }

    @DeleteMapping(value = "/image/{entityId}/{imageKey}")
    boolean removeImage(@PathVariable String entityId, @PathVariable String imageKey) {
        return getService().removeImage(entityId, imageKey);
    }
}
