package com.elements.elementsapi.api.realm.repository;

import com.elements.elementsdomain.document.Realm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealmRepository extends MongoRepository<Realm, String> {
    List<Realm> findAllByCreatedBy(String username);
}
