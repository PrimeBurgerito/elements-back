package com.elements.elementsapi.api.game.npctemplate.service.mapper;

import com.elements.elementsapi.api.game.npctemplate.service.resource.NpcTemplateDto;
import com.elements.elementsdomain.document.npc.NpcTemplate;
import com.elements.elementsdomain.document.npc.NpcTemplate.NpcTemplateBuilder;
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
public class NpcTemplateMapperImpl implements NpcTemplateMapper {

    @Override
    public NpcTemplateDto map(NpcTemplate document) {
        if ( document == null ) {
            return null;
        }

        NpcTemplateDto npcTemplateDto = new NpcTemplateDto();

        npcTemplateDto.setRealmId( document.getRealmId() );
        npcTemplateDto.setRank( document.getRank() );

        return npcTemplateDto;
    }

    @Override
    public List<NpcTemplateDto> map(Collection<NpcTemplate> documents) {
        if ( documents == null ) {
            return null;
        }

        List<NpcTemplateDto> list = new ArrayList<NpcTemplateDto>( documents.size() );
        for ( NpcTemplate npcTemplate : documents ) {
            list.add( map( npcTemplate ) );
        }

        return list;
    }

    @Override
    public NpcTemplate map(NpcTemplateDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        NpcTemplateBuilder<?, ?> npcTemplate = NpcTemplate.builder();

        npcTemplate.realmId( documentDto.getRealmId() );
        npcTemplate.rank( documentDto.getRank() );

        return npcTemplate.build();
    }

    @Override
    public void update(NpcTemplateDto dto, NpcTemplate document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setRank( dto.getRank() );
    }
}
