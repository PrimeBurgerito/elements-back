package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementscommon.domain.DocumentBase;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<D, T extends DocumentBase> {

    protected abstract BaseService<D, T> getService();

    @PostMapping
    public T create(@Valid @RequestBody D entityDto) {
        return getService().create(entityDto);
    }

    @GetMapping
    public List<T> find() {
        return getService().find();
    }

    @GetMapping(value = "/{entityId}")
    public T get(@PathVariable String entityId) {
        return getService().get(entityId);
    }

    @PutMapping(value = "/{entityId}")
    public D update(@PathVariable String entityId, @RequestBody D entityDto) {
        return getService().update(entityId, entityDto);
    }

    @DeleteMapping(value = "/{entityId}")
    public boolean delete(@PathVariable String entityId) {
        return getService().delete(entityId);
    }
}
