package com.elements.elementsapi.api.game.property.controller;

import com.elements.elementsapi.api.game.property.service.resource.NumericPropertyDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentController;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/attribute")
public class NumericPropertyController extends RealmDocumentController<NumericPropertyDto, NumericPropertyTemplate> {
}
