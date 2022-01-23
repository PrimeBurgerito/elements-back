package com.elements.elementsapi.api.game.container.keycontainer.service.mapper;

import com.elements.elementsapi.api.game.container.keycontainer.service.resource.KeyContainerDto;
import com.elements.elementsdomain.document.container.Key;
import com.elements.elementsdomain.document.container.KeyContainer;
import com.elements.elementsdomain.document.container.KeyContainer.KeyContainerBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T17:10:21+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class KeyContainerMapperImpl implements KeyContainerMapper {

    @Override
    public KeyContainerDto map(KeyContainer document) {
        if ( document == null ) {
            return null;
        }

        KeyContainerDto keyContainerDto = new KeyContainerDto();

        keyContainerDto.setRealmId( document.getRealmId() );
        keyContainerDto.setKey( document.getKey() );
        Set<Key> set = document.getKeys();
        if ( set != null ) {
            keyContainerDto.setKeys( new HashSet<Key>( set ) );
        }

        return keyContainerDto;
    }

    @Override
    public List<KeyContainerDto> map(Collection<KeyContainer> documents) {
        if ( documents == null ) {
            return null;
        }

        List<KeyContainerDto> list = new ArrayList<KeyContainerDto>( documents.size() );
        for ( KeyContainer keyContainer : documents ) {
            list.add( map( keyContainer ) );
        }

        return list;
    }

    @Override
    public KeyContainer map(KeyContainerDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        KeyContainerBuilder<?, ?> keyContainer = KeyContainer.builder();

        keyContainer.realmId( documentDto.getRealmId() );
        keyContainer.key( documentDto.getKey() );
        Set<Key> set = documentDto.getKeys();
        if ( set != null ) {
            keyContainer.keys( new HashSet<Key>( set ) );
        }

        return keyContainer.build();
    }

    @Override
    public void update(KeyContainerDto dto, KeyContainer document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setKey( dto.getKey() );
        if ( document.getKeys() != null ) {
            Set<Key> set = dto.getKeys();
            if ( set != null ) {
                document.getKeys().clear();
                document.getKeys().addAll( set );
            }
            else {
                document.setKeys( null );
            }
        }
        else {
            Set<Key> set = dto.getKeys();
            if ( set != null ) {
                document.setKeys( new HashSet<Key>( set ) );
            }
        }
    }
}
