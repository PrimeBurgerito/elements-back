package com.elements.elementsdomain.statistic;

import com.elements.elementscommon.domain.DocumentBase;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@EqualsAndHashCode(callSuper = true)
abstract class Statistic extends DocumentBase {
    @Indexed(unique = true)
    private String name;
}
