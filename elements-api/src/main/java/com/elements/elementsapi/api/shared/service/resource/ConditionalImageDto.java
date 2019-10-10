package com.elements.elementsapi.api.shared.service.resource;

import com.elements.elementsdomain.composite.image.ImageCrop;
import com.elements.elementsdomain.composite.requirement.Requirement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.util.Map;

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
    @Nullable
    private Map<String, ImageCrop> crops;
}
