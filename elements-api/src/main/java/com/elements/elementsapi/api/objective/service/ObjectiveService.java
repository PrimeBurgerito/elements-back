package com.elements.elementsapi.api.objective.service;

import com.elements.elementsapi.api.objective.repository.ObjectiveRepository;
import com.elements.elementsapi.api.objective.service.mapper.ObjectiveMapper;
import com.elements.elementsapi.api.objective.service.resource.ObjectiveDto;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsdomain.document.objective.Objective;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ObjectiveService extends BaseService<ObjectiveDto, Objective> {

    private final ObjectiveRepository repository;
    private final ObjectiveMapper mapper;

    @Override
    public ObjectiveRepository getRepository() {
        return repository;
    }

    @Override
    protected ObjectiveMapper getMapper() {
        return mapper;
    }
}
