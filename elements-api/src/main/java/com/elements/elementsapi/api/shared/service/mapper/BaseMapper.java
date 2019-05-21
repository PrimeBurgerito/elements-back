package com.elements.elementsapi.api.shared.service.mapper;

import com.elements.elementscommon.domain.DocumentBase;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<D, T extends DocumentBase> {

    D map(T location);

    List<D> map(Collection<T> locations);

    T map(D locationDto);
}
