package com.elements.elementsapi.api.game.property.controller;

import com.elements.elementsapi.api.game.property.service.resource.StringPropertyDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentController;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/property")
public class StringPropertyController extends RealmDocumentController<StringPropertyDto, StringPropertyTemplate> {
}
