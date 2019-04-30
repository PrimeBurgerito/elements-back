package com.elements.elementsapi.api.location.domain;

import com.arangodb.springframework.annotation.Document;
import com.elements.elementsapi.api.DocumentBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Location extends DocumentBase {
    private String name;
}
