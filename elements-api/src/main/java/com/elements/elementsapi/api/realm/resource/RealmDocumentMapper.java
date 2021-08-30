package com.elements.elementsapi.api.realm.resource;

import com.elements.elementsdomain.document.RealmDocument;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

public interface RealmDocumentMapper<D extends RealmDocumentDto, T extends RealmDocument> {
    D map(T document);

    List<D> map(Collection<T> documents);

    T map(D documentDto);

    void update(D dto, @MappingTarget T document);
}
