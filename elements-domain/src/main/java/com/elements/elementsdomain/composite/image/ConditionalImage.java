package com.elements.elementsdomain.composite.image;

import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConditionalImage {
    private Image image;
    private Requirement requirement;
}
