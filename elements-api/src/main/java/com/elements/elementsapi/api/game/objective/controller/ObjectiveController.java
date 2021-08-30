package com.elements.elementsapi.api.game.objective.controller;

import com.elements.elementsapi.api.game.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentController;
import com.elements.elementsdomain.document.objective.Objective;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/objective")
public class ObjectiveController extends RealmDocumentController<ObjectiveDto, Objective> {
}
