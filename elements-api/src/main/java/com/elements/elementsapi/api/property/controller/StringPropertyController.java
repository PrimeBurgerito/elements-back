package com.elements.elementsapi.api.property.controller;

import com.elements.elementsapi.api.shared.controller.BaseController;
import com.elements.elementsapi.api.property.service.StringPropertyService;
import com.elements.elementsapi.api.property.service.resource.StringPropertyDto;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/property")
public class StringPropertyController extends BaseController<StringPropertyDto, StringPropertyTemplate> {

    private final StringPropertyService service;

    @Override
    protected StringPropertyService getService() {
        return service;
    }
}
