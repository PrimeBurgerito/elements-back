package com.elements.elementsapi.api.shared.service.resource;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ConditionalImageDto {
    @NotBlank
    private String entityId;
    @NotBlank
    private String imageKey;
    @Nullable
    private Requirement requirement;
}
