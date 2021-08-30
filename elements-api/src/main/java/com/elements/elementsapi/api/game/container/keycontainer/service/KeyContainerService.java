package com.elements.elementsapi.api.game.container.keycontainer.service;

import com.elements.elementsapi.api.game.container.keycontainer.repository.KeyContainerRepository;
import com.elements.elementsapi.api.game.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsapi.api.realm.service.RealmDocumentService;
import com.elements.elementsdomain.document.container.KeyContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class KeyContainerService extends RealmDocumentService<KeyContainerDto, KeyContainer> {

    @Transactional(readOnly = true)
    public KeyContainerDto findByKey(String key) {
        return mapper.map(((KeyContainerRepository) repository).findByKey(key));
    }

    @Transactional(readOnly = true)
    public List<KeyContainerDto> findByKeys(Set<String> keys) {
        return mapper.map(((KeyContainerRepository) repository).findByKeyIn(keys));
    }
}
