package com.elements.elementsdomain.document.location.area;

import com.mongodb.client.model.geojson.Point;
import lombok.Data;

@Data
public class LocationInfo {
    private String id;
    private Point position;
}
