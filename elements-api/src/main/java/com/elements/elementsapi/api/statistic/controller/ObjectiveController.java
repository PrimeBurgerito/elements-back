package com.elements.elementsapi.api.statistic.controller;

import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsapi.api.statistic.service.ObjectiveService;
import com.elements.elementsapi.api.statistic.service.resource.ObjectiveDto;
import com.elements.elementsdomain.statistic.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/objective")
public class ObjectiveController extends BaseController<ObjectiveDto, Objective> {

    private final ObjectiveService service;

    @Override
    protected ObjectiveService getService() {
        return service;
    }
}
