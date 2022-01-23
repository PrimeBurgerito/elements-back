package com.elements.elementsapi.api.game.event.service.mapper;

import com.elements.elementsapi.api.game.event.service.resource.EventDto;
import com.elements.elementsdomain.document.event.Event;
import com.elements.elementsdomain.document.event.Event.EventBuilder;
import com.elements.elementsdomain.document.event.scene.SceneBase;
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
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDto map(Event document) {
        if ( document == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setRealmId( document.getRealmId() );
        eventDto.setName( document.getName() );
        eventDto.setRequirement( document.getRequirement() );
        List<SceneBase> list = document.getScenes();
        if ( list != null ) {
            eventDto.setScenes( new ArrayList<SceneBase>( list ) );
        }

        return eventDto;
    }

    @Override
    public List<EventDto> map(Collection<Event> documents) {
        if ( documents == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<EventDto>( documents.size() );
        for ( Event event : documents ) {
            list.add( map( event ) );
        }

        return list;
    }

    @Override
    public Event map(EventDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        EventBuilder<?, ?> event = Event.builder();

        event.realmId( documentDto.getRealmId() );
        event.name( documentDto.getName() );
        event.requirement( documentDto.getRequirement() );
        List<SceneBase> list = documentDto.getScenes();
        if ( list != null ) {
            event.scenes( new ArrayList<SceneBase>( list ) );
        }

        return event.build();
    }

    @Override
    public void update(EventDto dto, Event document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setName( dto.getName() );
        document.setRequirement( dto.getRequirement() );
        if ( document.getScenes() != null ) {
            List<SceneBase> list = dto.getScenes();
            if ( list != null ) {
                document.getScenes().clear();
                document.getScenes().addAll( list );
            }
            else {
                document.setScenes( null );
            }
        }
        else {
            List<SceneBase> list = dto.getScenes();
            if ( list != null ) {
                document.setScenes( new ArrayList<SceneBase>( list ) );
            }
        }
    }
}
