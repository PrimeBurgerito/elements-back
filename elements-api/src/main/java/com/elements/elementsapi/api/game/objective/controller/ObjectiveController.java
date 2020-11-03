package com.elements.elementsapi.api.game.objective.controller;

import com.elements.elementsapi.api.game.objective.service.ObjectiveService;
import com.elements.elementsapi.api.game.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsdomain.document.objective.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/objective")
public class ObjectiveController extends BaseController<ObjectiveDto, Objective> {

    private final ObjectiveService service;

    @Override
    protected ObjectiveService getService() {
        return service;
    }
}
