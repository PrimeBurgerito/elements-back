package com.elements.elementsapi.api.shared.service;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementscommon.domain.DocumentBase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseService<D, T extends DocumentBase> {

    public abstract MongoRepository<T, String> getRepository();

    protected abstract BaseMapper<D, T> getMapper();

    public D create(D entityDto) {
        T entity = getMapper().map(entityDto);
        return getMapper().map(getRepository().save(entity));
    }

    public D update(String entityId, D entityDto) {
        return null;
    }

    @Transactional(readOnly = true)
    public List<D> find() {
        return getMapper().map(getRepository().findAll());
    }

    @Transactional(readOnly = true)
    public D get(String entityId) {
        return getMapper().map(findById(entityId));
    }

    protected T findById(String entityId) {
        return getRepository().findById(entityId)
                .orElseThrow(() -> new RuntimeException("Entity not found. ID: " + entityId));
    }
}
