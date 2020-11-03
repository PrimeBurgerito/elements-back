package com.elements.elementsapi.api.game.property.controller;

import com.elements.elementsapi.api.game.property.service.NumericPropertyService;
import com.elements.elementsapi.api.game.property.service.resource.NumericPropertyDto;
import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/attribute")
public class NumericPropertyController extends BaseController<NumericPropertyDto, NumericPropertyTemplate> {

    private final NumericPropertyService service;

    @Override
    protected NumericPropertyService getService() {
        return service;
    }
}
