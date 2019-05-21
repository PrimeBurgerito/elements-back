package com.elements.elementsapi.api.statistic.service;

import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.statistic.repository.ObjectiveRepository;
import com.elements.elementsapi.api.statistic.service.mapper.ObjectiveMapper;
import com.elements.elementsapi.api.statistic.service.resource.ObjectiveDto;
import com.elements.elementsdomain.statistic.Objective;
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
