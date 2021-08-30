package com.elements.elementsapi.api.realm.service;

import com.elements.elementsapi.api.realm.repository.RealmDocumentRepository;
import com.elements.elementsapi.api.realm.resource.RealmDocumentDto;
import com.elements.elementsapi.api.realm.resource.RealmDocumentMapper;
import com.elements.elementsdomain.document.RealmDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.text.MessageFormat.format;

@Transactional
@RequiredArgsConstructor
public abstract class RealmDocumentService<D extends RealmDocumentDto, T extends RealmDocument> {
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    protected RealmDocumentMapper<D, T> mapper;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    protected RealmDocumentRepository<T> repository;

    public T create(D entityDto) {
        T entity = mapper.map(entityDto);
        return repository.save(entity);
    }

    public D update(String entityId, D update) {
        Optional<T> entity = repository.findById(entityId);
        if (entity.isEmpty()) {
            throw new RuntimeException("Entity not found. ID: " + entityId);
        } else if (!entity.get().getRealmId().equals(update.getRealmId())) {
            String message = format("Realm id's do not match: {0} != {1}", entity.get().getRealmId(), update.getRealmId());
            throw new RuntimeException(message);
        }
        mapper.update(update, entity.get());
        return mapper.map(repository.save(entity.get()));
    }

    @Transactional(readOnly = true)
    public List<T> find(String realmId) {
        return realmId != null ? repository.findAllByRealmId(realmId) : repository.findAll();
    }

    @Transactional(readOnly = true)
    public T get(String entityId) {
        return findById(entityId);
    }

    public boolean delete(String entityId) {
        if (repository.existsById(entityId)) {
            repository.deleteById(entityId);
            return true;
        }
        return false;
    }

    protected T findById(String entityId) {
        return repository.findById(entityId)
                .orElseThrow(() -> new RuntimeException("Entity not found. ID: " + entityId));
    }
}
