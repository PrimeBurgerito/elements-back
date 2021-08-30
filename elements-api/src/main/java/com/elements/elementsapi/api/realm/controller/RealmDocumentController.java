package com.elements.elementsapi.api.realm.controller;

import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentService;
import com.elements.elementsdomain.document.RealmDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public abstract class RealmDocumentController<D extends RealmDocumentDto, T extends RealmDocument> {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    protected RealmDocumentService<D, T> service;

    @PostMapping
    public T create(@Valid @RequestBody D entityDto) {
        return service.create(entityDto);
    }

    @GetMapping
    public List<T> find(@RequestParam(required = false) String realmId) {
        return service.find(realmId);
    }

    @GetMapping(value = "/{entityId}")
    public T get(@PathVariable String entityId) {
        return service.get(entityId);
    }

    @PutMapping(value = "/{entityId}")
    public D update(@PathVariable String entityId, @RequestBody D entityDto) {
        return service.update(entityId, entityDto);
    }

    @DeleteMapping(value = "/{entityId}")
    public boolean delete(@PathVariable String entityId) {
        return service.delete(entityId);
    }
}
