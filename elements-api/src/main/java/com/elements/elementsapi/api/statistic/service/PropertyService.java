package com.elements.elementsapi.api.statistic.service;

import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsapi.api.statistic.repository.PropertyRepository;
import com.elements.elementsapi.api.statistic.service.mapper.PropertyMapper;
import com.elements.elementsapi.api.statistic.service.resource.PropertyDto;
import com.elements.elementsdomain.aggregate.statistic.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PropertyService extends BaseService<PropertyDto, Property> {

    private final PropertyRepository repository;
    private final PropertyMapper mapper;

    @Override
    public PropertyRepository getRepository() {
        return repository;
    }

    @Override
    protected PropertyMapper getMapper() {
        return mapper;
    }
}
