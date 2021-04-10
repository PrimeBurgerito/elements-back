package com.elements.gamesession.session.crud.location.service;

import com.elements.elementsdomain.document.location.Location;
import com.elements.gamesession.session.crud.location.repository.SessionLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SessionLocationService {

    private final SessionLocationRepository repository;

    public Location getById(String id) {
        return repository.get(id);
    }

    public Location getByName(String name) {
        return repository.getByName(name);
    }
}
