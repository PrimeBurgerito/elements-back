package com.elements.elementsapi.api.game.property.service.mapper;

import com.elements.elementsapi.api.game.property.service.resource.StringPropertyDto;
import com.elements.elementsdomain.document.propertytemplate.StringPropertyTemplate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T17:10:22+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class StringPropertyMapperImpl implements StringPropertyMapper {

    @Override
    public StringPropertyDto map(StringPropertyTemplate document) {
        if ( document == null ) {
            return null;
        }

        StringPropertyDto stringPropertyDto = new StringPropertyDto();

        stringPropertyDto.setRealmId( document.getRealmId() );
        stringPropertyDto.setName( document.getName() );
        List<String> list = document.getValue();
        if ( list != null ) {
            stringPropertyDto.setValue( new ArrayList<String>( list ) );
        }
        stringPropertyDto.setKey( document.getKey() );
        Set<String> set = document.getPossibleValues();
        if ( set != null ) {
            stringPropertyDto.setPossibleValues( new HashSet<String>( set ) );
        }
        stringPropertyDto.setType( document.getType() );

        return stringPropertyDto;
    }

    @Override
    public List<StringPropertyDto> map(Collection<StringPropertyTemplate> documents) {
        if ( documents == null ) {
            return null;
        }

        List<StringPropertyDto> list = new ArrayList<StringPropertyDto>( documents.size() );
        for ( StringPropertyTemplate stringPropertyTemplate : documents ) {
            list.add( map( stringPropertyTemplate ) );
        }

        return list;
    }

    @Override
    public StringPropertyTemplate map(StringPropertyDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        StringPropertyTemplate stringPropertyTemplate = new StringPropertyTemplate();

        stringPropertyTemplate.setRealmId( documentDto.getRealmId() );
        stringPropertyTemplate.setKey( documentDto.getKey() );
        stringPropertyTemplate.setName( documentDto.getName() );
        List<String> list = documentDto.getValue();
        if ( list != null ) {
            stringPropertyTemplate.setValue( new ArrayList<String>( list ) );
        }
        Set<String> set = documentDto.getPossibleValues();
        if ( set != null ) {
            stringPropertyTemplate.setPossibleValues( new HashSet<String>( set ) );
        }
        stringPropertyTemplate.setType( documentDto.getType() );

        return stringPropertyTemplate;
    }

    @Override
    public void update(StringPropertyDto dto, StringPropertyTemplate document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setKey( dto.getKey() );
        document.setName( dto.getName() );
        if ( document.getValue() != null ) {
            List<String> list = dto.getValue();
            if ( list != null ) {
                document.getValue().clear();
                document.getValue().addAll( list );
            }
            else {
                document.setValue( null );
            }
        }
        else {
            List<String> list = dto.getValue();
            if ( list != null ) {
                document.setValue( new ArrayList<String>( list ) );
            }
        }
        if ( document.getPossibleValues() != null ) {
            Set<String> set = dto.getPossibleValues();
            if ( set != null ) {
                document.getPossibleValues().clear();
                document.getPossibleValues().addAll( set );
            }
            else {
                document.setPossibleValues( null );
            }
        }
        else {
            Set<String> set = dto.getPossibleValues();
            if ( set != null ) {
                document.setPossibleValues( new HashSet<String>( set ) );
            }
        }
        document.setType( dto.getType() );
    }
}
