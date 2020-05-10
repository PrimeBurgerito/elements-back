package com.elements.elementsapi.api.shared.service.mapper;

import com.elements.elementscommon.domain.DocumentBase;
import org.mapstruct.MappingTarget;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<D, T extends DocumentBase> {

    D map(T document);

    List<D> map(Collection<T> documents);

    T map(D documentDto);

    void update(D dto, @MappingTarget T document);
}
