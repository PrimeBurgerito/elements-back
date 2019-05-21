package com.elements.elementsapi.api.shared.controller;

import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementscommon.domain.DocumentBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class BaseController<D, T extends DocumentBase> {

    protected abstract BaseService<D, T> getService();

    @PostMapping
    public D create(@RequestBody D locationDto) {
        return getService().create(locationDto);
    }

    @GetMapping
    public List<D> find() {
        return getService().find();
    }

    @GetMapping(value = "/{entityId}")
    public D get(@PathVariable String entityId) {
        return getService().get(entityId);
    }
}
