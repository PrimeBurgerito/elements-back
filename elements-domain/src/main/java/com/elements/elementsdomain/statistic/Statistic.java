package com.elements.elementsdomain.statistic;

import com.elements.elementscommon.domain.DocumentBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
abstract class Statistic extends DocumentBase {
    private String name;
}
