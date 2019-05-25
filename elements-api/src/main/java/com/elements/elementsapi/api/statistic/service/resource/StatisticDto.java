package com.elements.elementsapi.api.statistic.service.resource;


import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import static org.springframework.util.StringUtils.capitalize;

@Data
abstract class StatisticDto {
    @NotBlank
    private String name;

    @JsonSetter
    public void setName(String name) {
        this.name = capitalize(name.toLowerCase()).strip();
    }
}
