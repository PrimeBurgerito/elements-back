package com.elements.elementsdomain.shared.image;

import com.elements.elementsdomain.shared.requirement.Requirement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConditionalImage {
    private Image image;
    private Requirement requirement;
}
