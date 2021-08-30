package com.elements.elementsapi.api.realm.controller;

import com.elements.elementsapi.api.realm.resource.RealmDto;
import com.elements.elementsapi.api.realm.service.RealmService;
import com.elements.elementsdomain.document.Realm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/realm")
public class RealmController {
    private final RealmService service;

    @PostMapping
    public Realm create(@Valid @RequestBody RealmDto entityDto) {
        return service.create(entityDto);
    }

    @GetMapping(value = "/{entityId}")
    public Realm get(@PathVariable String entityId) {
        return service.get(entityId);
    }

    @GetMapping(value = "/owned")
    public List<Realm> getMine() {
        return service.getMine();
    }
}
