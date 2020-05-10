package com.elements.gamesession.session.crud.location.repository;

import com.elements.elementsdomain.document.location.Location;

public interface SessionLocationRepository {
    Location get(String locationId);
    Location getByName(String locationName);
}
