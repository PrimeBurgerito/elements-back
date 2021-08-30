package com.elements.elementsapi.api.realm.repository;

import com.elements.elementsdomain.document.RealmDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RealmDocumentRepository<T extends RealmDocument> extends MongoRepository<T, String> {
    List<T> findAllByRealmId(String realmId);
}
