package com.elements.elementsapi.api.realm.resource;

import com.elements.elementsdomain.document.Realm;
import com.elements.elementsdomain.document.Realm.RealmBuilder;
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
public class RealmMapperImpl implements RealmMapper {

    @Override
    public RealmDto map(Realm document) {
        if ( document == null ) {
            return null;
        }

        RealmDto realmDto = new RealmDto();

        realmDto.setName( document.getName() );
        realmDto.setId( document.getId() );

        return realmDto;
    }

    @Override
    public List<RealmDto> map(Collection<Realm> documents) {
        if ( documents == null ) {
            return null;
        }

        List<RealmDto> list = new ArrayList<RealmDto>( documents.size() );
        for ( Realm realm : documents ) {
            list.add( map( realm ) );
        }

        return list;
    }

    @Override
    public Realm map(RealmDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        RealmBuilder<?, ?> realm = Realm.builder();

        realm.id( documentDto.getId() );
        realm.name( documentDto.getName() );

        return realm.build();
    }

    @Override
    public void update(RealmDto dto, Realm document) {
        if ( dto == null ) {
            return;
        }

        document.setId( dto.getId() );
        document.setName( dto.getName() );
    }
}
