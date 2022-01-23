package com.elements.elementsapi.api.game.property.service.mapper;

import com.elements.elementsapi.api.game.property.service.resource.NumericPropertyDto;
import com.elements.elementsdomain.document.propertytemplate.NumericPropertyTemplate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T17:10:22+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class NumericPropertyMapperImpl implements NumericPropertyMapper {

    @Override
    public NumericPropertyDto map(NumericPropertyTemplate document) {
        if ( document == null ) {
            return null;
        }

        NumericPropertyDto numericPropertyDto = new NumericPropertyDto();

        numericPropertyDto.setRealmId( document.getRealmId() );
        numericPropertyDto.setName( document.getName() );
        numericPropertyDto.setValue( document.getValue() );
        numericPropertyDto.setKey( document.getKey() );
        numericPropertyDto.setMin( document.getMin() );
        numericPropertyDto.setMax( document.getMax() );

        return numericPropertyDto;
    }

    @Override
    public List<NumericPropertyDto> map(Collection<NumericPropertyTemplate> documents) {
        if ( documents == null ) {
            return null;
        }

        List<NumericPropertyDto> list = new ArrayList<NumericPropertyDto>( documents.size() );
        for ( NumericPropertyTemplate numericPropertyTemplate : documents ) {
            list.add( map( numericPropertyTemplate ) );
        }

        return list;
    }

    @Override
    public NumericPropertyTemplate map(NumericPropertyDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        NumericPropertyTemplate numericPropertyTemplate = new NumericPropertyTemplate();

        numericPropertyTemplate.setRealmId( documentDto.getRealmId() );
        numericPropertyTemplate.setKey( documentDto.getKey() );
        numericPropertyTemplate.setName( documentDto.getName() );
        numericPropertyTemplate.setValue( documentDto.getValue() );
        numericPropertyTemplate.setMin( documentDto.getMin() );
        numericPropertyTemplate.setMax( documentDto.getMax() );

        return numericPropertyTemplate;
    }

    @Override
    public void update(NumericPropertyDto dto, NumericPropertyTemplate document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setKey( dto.getKey() );
        document.setName( dto.getName() );
        document.setValue( dto.getValue() );
        document.setMin( dto.getMin() );
        document.setMax( dto.getMax() );
    }
}
