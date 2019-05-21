package com.elements.elementsapi.api.statistic.controller;

import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsapi.api.statistic.service.AttributeService;
import com.elements.elementsapi.api.statistic.service.resource.AttributeDto;
import com.elements.elementsdomain.statistic.Attribute;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/attribute")
public class AttributeController extends BaseController<AttributeDto, Attribute> {

    private final AttributeService service;

    @Override
    protected AttributeService getService() {
        return service;
    }
}
