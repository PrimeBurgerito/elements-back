package com.elements.elementsapi.api.realm.controller;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentConditionalImageService;
import com.elements.elementsapi.api.shared.service.resource.ConditionalImageDto;
import com.elements.elementsdomain.document.RealmDocument;
import com.elements.elementsdomain.shared.image.ConditionalImage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class RealmDocumentConditionalImageController<D extends RealmDocumentDto, T extends RealmDocument> extends RealmDocumentController<D, T> {
    @PutMapping(value = "/image", consumes = {"multipart/form-data"})
    public ConditionalImage addImage(
            @RequestPart("imageDto") @Valid ConditionalImageDto imageDto,
            @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file
    ) {
        return ((RealmDocumentConditionalImageService<D, T>) service).addImage(imageDto, file);
    }

    @DeleteMapping(value = "/image/{entityId}/{imageKey}")
    public boolean removeImage(@PathVariable String entityId, @PathVariable String imageKey) {
        return ((RealmDocumentConditionalImageService<D, T>) service).removeImage(entityId, imageKey);
    }
}
