package com.elements.elementsapi.api.game.locationarea.service.mapper;

import com.elements.elementsapi.api.game.locationarea.service.resource.LocationAreaDto;
import com.elements.elementsdomain.document.location.area.LocationArea;
import com.elements.elementsdomain.document.location.area.LocationArea.LocationAreaBuilder;
import com.elements.elementsdomain.document.location.area.LocationInfo;
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
public class LocationAreaMapperImpl implements LocationAreaMapper {

    @Override
    public LocationAreaDto map(LocationArea document) {
        if ( document == null ) {
            return null;
        }

        LocationAreaDto locationAreaDto = new LocationAreaDto();

        locationAreaDto.setName( document.getName() );
        locationAreaDto.setRequirement( document.getRequirement() );
        locationAreaDto.setParentAreaId( document.getParentAreaId() );
        Set<LocationInfo> set = document.getChildren();
        if ( set != null ) {
            locationAreaDto.setChildren( new HashSet<LocationInfo>( set ) );
        }
        locationAreaDto.setImage( document.getImage() );
        locationAreaDto.setType( document.getType() );

        return locationAreaDto;
    }

    @Override
    public List<LocationAreaDto> map(Collection<LocationArea> documents) {
        if ( documents == null ) {
            return null;
        }

        List<LocationAreaDto> list = new ArrayList<LocationAreaDto>( documents.size() );
        for ( LocationArea locationArea : documents ) {
            list.add( map( locationArea ) );
        }

        return list;
    }

    @Override
    public LocationArea map(LocationAreaDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        LocationAreaBuilder<?, ?> locationArea = LocationArea.builder();

        locationArea.name( documentDto.getName() );
        locationArea.requirement( documentDto.getRequirement() );
        locationArea.parentAreaId( documentDto.getParentAreaId() );
        Set<LocationInfo> set = documentDto.getChildren();
        if ( set != null ) {
            locationArea.children( new HashSet<LocationInfo>( set ) );
        }
        locationArea.image( documentDto.getImage() );
        locationArea.type( documentDto.getType() );

        return locationArea.build();
    }

    @Override
    public void update(LocationAreaDto dto, LocationArea document) {
        if ( dto == null ) {
            return;
        }

        document.setName( dto.getName() );
        document.setRequirement( dto.getRequirement() );
        document.setParentAreaId( dto.getParentAreaId() );
        if ( document.getChildren() != null ) {
            Set<LocationInfo> set = dto.getChildren();
            if ( set != null ) {
                document.getChildren().clear();
                document.getChildren().addAll( set );
            }
            else {
                document.setChildren( null );
            }
        }
        else {
            Set<LocationInfo> set = dto.getChildren();
            if ( set != null ) {
                document.setChildren( new HashSet<LocationInfo>( set ) );
            }
        }
        document.setImage( dto.getImage() );
        document.setType( dto.getType() );
    }
}
