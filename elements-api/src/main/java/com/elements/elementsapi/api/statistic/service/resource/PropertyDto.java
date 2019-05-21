package com.elements.elementsapi.api.statistic.service.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PropertyDto extends StatisticDto {
    private Set<String> values;
}
