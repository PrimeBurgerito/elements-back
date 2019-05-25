package com.elements.elementsapi.api.statistic.service.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class PropertyDto extends StatisticDto {
    @NotEmpty
    private Set<String> values;
}
