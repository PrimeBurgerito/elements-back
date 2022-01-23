package com.elements.elementsapi.api.game.objective.service.mapper;

import com.elements.elementsapi.api.game.objective.service.resource.ObjectiveDto;
import com.elements.elementsdomain.document.objective.Objective;
import com.elements.elementsdomain.document.objective.Objective.ObjectiveBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-30T17:10:21+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.1.jar, environment: Java 13 (Oracle Corporation)"
)
@Component
public class ObjectiveMapperImpl implements ObjectiveMapper {

    @Override
    public ObjectiveDto map(Objective document) {
        if ( document == null ) {
            return null;
        }

        ObjectiveDto objectiveDto = new ObjectiveDto();

        objectiveDto.setRealmId( document.getRealmId() );
        objectiveDto.setValue( document.getValue() );

        return objectiveDto;
    }

    @Override
    public List<ObjectiveDto> map(Collection<Objective> documents) {
        if ( documents == null ) {
            return null;
        }

        List<ObjectiveDto> list = new ArrayList<ObjectiveDto>( documents.size() );
        for ( Objective objective : documents ) {
            list.add( map( objective ) );
        }

        return list;
    }

    @Override
    public Objective map(ObjectiveDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        ObjectiveBuilder<?, ?> objective = Objective.builder();

        objective.realmId( documentDto.getRealmId() );
        objective.value( documentDto.getValue() );

        return objective.build();
    }

    @Override
    public void update(ObjectiveDto dto, Objective document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
    }
}
