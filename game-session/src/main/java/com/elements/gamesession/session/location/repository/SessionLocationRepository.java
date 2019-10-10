package com.elements.gamesession.session.location.repository;

import com.elements.elementsdomain.aggregate.location.Location;

public interface SessionLocationRepository {
    Location get(String locationId);
    Location getByName(String locationName);
}
