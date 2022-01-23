package com.elements.elementsapi.api.game.location.service.mapper;

import com.elements.elementsapi.api.game.location.service.resource.LocationDto;
import com.elements.elementsdomain.document.location.Location;
import com.elements.elementsdomain.document.location.Location.LocationBuilder;
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
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDto map(Location document) {
        if ( document == null ) {
            return null;
        }

        LocationDto locationDto = new LocationDto();

        locationDto.setRealmId( document.getRealmId() );
        locationDto.setName( document.getName() );
        Set<String> set = document.getNearbyLocations();
        if ( set != null ) {
            locationDto.setNearbyLocations( new HashSet<String>( set ) );
        }

        return locationDto;
    }

    @Override
    public List<LocationDto> map(Collection<Location> documents) {
        if ( documents == null ) {
            return null;
        }

        List<LocationDto> list = new ArrayList<LocationDto>( documents.size() );
        for ( Location location : documents ) {
            list.add( map( location ) );
        }

        return list;
    }

    @Override
    public Location map(LocationDto documentDto) {
        if ( documentDto == null ) {
            return null;
        }

        LocationBuilder<?, ?> location = Location.builder();

        location.realmId( documentDto.getRealmId() );
        location.name( documentDto.getName() );
        Set<String> set = documentDto.getNearbyLocations();
        if ( set != null ) {
            location.nearbyLocations( new HashSet<String>( set ) );
        }

        return location.build();
    }

    @Override
    public void update(LocationDto dto, Location document) {
        if ( dto == null ) {
            return;
        }

        document.setRealmId( dto.getRealmId() );
        document.setName( dto.getName() );
        if ( document.getNearbyLocations() != null ) {
            Set<String> set = dto.getNearbyLocations();
            if ( set != null ) {
                document.getNearbyLocations().clear();
                document.getNearbyLocations().addAll( set );
            }
            else {
                document.setNearbyLocations( null );
            }
        }
        else {
            Set<String> set = dto.getNearbyLocations();
            if ( set != null ) {
                document.setNearbyLocations( new HashSet<String>( set ) );
            }
        }
    }
}
