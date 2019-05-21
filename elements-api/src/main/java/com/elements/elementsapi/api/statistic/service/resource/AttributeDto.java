package com.elements.elementsapi.api.statistic.service.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttributeDto extends StatisticDto {
    private float min;
    private float max;
}
