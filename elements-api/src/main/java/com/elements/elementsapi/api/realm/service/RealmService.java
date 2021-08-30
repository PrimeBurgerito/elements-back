package com.elements.elementsapi.api.realm.service;

import com.elements.elementsapi.api.realm.repository.RealmRepository;
import com.elements.elementsapi.api.realm.resource.RealmDto;
import com.elements.elementsapi.api.realm.resource.RealmMapper;
import com.elements.elementsdomain.document.Realm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
@Transactional
@RequiredArgsConstructor
public class RealmService {
    private final RealmRepository repository;
    private final RealmMapper mapper;

    public Realm create(RealmDto entityDto) {
        Realm entity = mapper.map(entityDto);
        String username = getUserName();
        entity.setCreatedBy(username);
        entity.setCreated(Instant.now());
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public Realm get(String entityId) {
        return repository.findById(entityId).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<Realm> getMine() {
        String username = getUserName();
        return repository.findAllByCreatedBy(username);
    }

    private String getUserName() {
        Authentication authentication = getContext().getAuthentication();
        return authentication.getName();
    }
}
