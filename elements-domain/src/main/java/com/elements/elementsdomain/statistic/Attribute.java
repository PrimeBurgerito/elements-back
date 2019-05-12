package com.elements.elementsdomain.statistic;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Attribute extends Statistic {
    private float min;
    private float max;
}
