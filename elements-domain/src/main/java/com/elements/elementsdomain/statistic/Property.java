package com.elements.elementsdomain.statistic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Property extends Statistic {
    private Set<String> values;
}
