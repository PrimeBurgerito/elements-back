package com.elements.elementsapi.api.realm.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RealmDto {
    @NotBlank
    private String name;
    @NotBlank
    private String id;
}
