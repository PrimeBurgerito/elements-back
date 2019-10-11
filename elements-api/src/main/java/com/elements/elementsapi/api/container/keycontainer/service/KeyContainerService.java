package com.elements.elementsapi.api.container.keycontainer.service;

import com.elements.elementsapi.api.container.keycontainer.repository.KeyContainerRepository;
import com.elements.elementsapi.api.container.keycontainer.service.mapper.KeyContainerMapper;
import com.elements.elementsapi.api.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsapi.api.shared.service.BaseService;
import com.elements.elementsdomain.aggregate.container.KeyContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class KeyContainerService extends BaseService<KeyContainerDto, KeyContainer> {

    private final KeyContainerRepository repository;
    private final KeyContainerMapper mapper;

    @Override
    public KeyContainerRepository getRepository() {
        return repository;
    }

    @Override
    protected KeyContainerMapper getMapper() {
        return mapper;
    }

    @Transactional(readOnly = true)
    public KeyContainerDto findByKey(String key) {
        return mapper.map(repository.findByKey(key));
    }

    @Transactional(readOnly = true)
    public List<KeyContainerDto> findByKeys(Set<String> keys) {
        return mapper.map(repository.findByKeyIn(keys));
    }
}
