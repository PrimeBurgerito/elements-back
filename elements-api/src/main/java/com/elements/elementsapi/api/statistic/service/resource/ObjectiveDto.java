package com.elements.elementsapi.api.statistic.service.resource;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ObjectiveDto extends StatisticDto {
    @Override
    @JsonSetter
    public void setName(String name) {
        super.setName(name.replace(" ", "_").strip().toUpperCase());
    }
}
