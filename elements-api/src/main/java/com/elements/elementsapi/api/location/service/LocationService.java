package com.elements.elementsapi.api.location.service;

import com.elements.elementsapi.api.location.repository.LocationRepository;
import com.elements.elementsapi.api.location.service.mapper.LocationMapper;
import com.elements.elementsapi.api.location.service.resource.LocationDto;
import com.elements.elementsapi.api.location.domain.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDto create(LocationDto locationDto) {
        Location location = locationMapper.map(locationDto);
        return locationMapper.map(locationRepository.save(location));
    }

    @Transactional(readOnly = true)
    public List<LocationDto> find() {
        Collection<Location> locations = StreamSupport
                .stream(locationRepository.findAll().spliterator(), false)
                .collect(toList());
        return locationMapper.map(locations);
    }

}
