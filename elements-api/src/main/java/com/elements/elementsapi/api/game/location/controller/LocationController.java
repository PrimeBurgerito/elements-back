package com.elements.elementsapi.api.game.location.controller;

import com.elements.elementsapi.api.game.location.service.resource.LocationDto;
import com.elements.elementsapi.api.realm.controller.RealmDocumentConditionalImageController;
import com.elements.elementsdomain.document.location.Location;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/location")
public class LocationController extends RealmDocumentConditionalImageController<LocationDto, Location> {
}
