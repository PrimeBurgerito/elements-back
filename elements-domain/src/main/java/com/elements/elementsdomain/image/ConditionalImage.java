package com.elements.elementsdomain.image;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConditionalImage {

    private Image image;
    private Requirement requirement;
}
