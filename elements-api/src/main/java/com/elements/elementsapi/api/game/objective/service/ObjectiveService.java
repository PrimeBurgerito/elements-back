package com.elements.elementsapi.api.game.objective.service;

import com.elements.elementsapi.api.game.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentService;
import com.elements.elementsdomain.document.objective.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ObjectiveService extends RealmDocumentService<ObjectiveDto, Objective> {
}
