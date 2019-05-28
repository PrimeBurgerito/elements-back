package com.elements.elementsapi.api.shared.service.resource;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConditionalImageDto {
    @NotBlank
    private String entityId;
    @NotBlank
    private String imageKey;
    @Nullable
    private Requirement requirement;
}
