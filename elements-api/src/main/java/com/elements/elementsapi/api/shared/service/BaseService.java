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

    public T create(D entityDto) {
        T entity = getMapper().map(entityDto);
        return getRepository().save(entity);
    }

    public D update(String entityId, D entity) {
        if (getRepository().existsById(entityId)) {
            return getMapper().map(getRepository().save(getMapper().map(entity)));
        }
        throw new RuntimeException("Entity not found. ID: " + entityId);
    }

    @Transactional(readOnly = true)
    public List<T> find() {
        return getRepository().findAll();
    }

    @Transactional(readOnly = true)
    public T get(String entityId) {
        return findById(entityId);
    }

    public boolean delete(String entityId) {
        if (getRepository().existsById(entityId)) {
            getRepository().deleteById(entityId);
            return true;
        }
        return false;
    }

    protected T findById(String entityId) {
        return getRepository().findById(entityId)
                .orElseThrow(() -> new RuntimeException("Entity not found. ID: " + entityId));
    }
}
