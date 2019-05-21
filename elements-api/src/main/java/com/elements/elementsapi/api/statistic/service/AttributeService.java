package com.elements.elementsapi.api.statistic.service;

import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.statistic.repository.AttributeRepository;
import com.elements.elementsapi.api.statistic.service.mapper.AttributeMapper;
import com.elements.elementsapi.api.statistic.service.resource.AttributeDto;
import com.elements.elementsdomain.statistic.Attribute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AttributeService extends BaseService<AttributeDto, Attribute> {

    private final AttributeRepository repository;
    private final AttributeMapper mapper;

    @Override
    public AttributeRepository getRepository() {
        return repository;
    }

    @Override
    protected AttributeMapper getMapper() {
        return mapper;
    }
}
