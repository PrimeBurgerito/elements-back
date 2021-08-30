package com.elements.elementsapi.api.realm.resource;

import com.elements.elementsapi.api.shared.service.mapper.BaseMapper;
import com.elements.elementsdomain.document.Realm;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface RealmMapper extends BaseMapper<RealmDto, Realm> {
}
