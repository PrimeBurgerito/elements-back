package com.elements.elementsapi.api.shared.service.resource;

import com.elements.elementsdomain.composite.image.ImageCrop;
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
public class ImageDto {
    @NotBlank
    private String entityId;
    @NotBlank
    private String imageKey;
    @Nullable
    private Map<String, ImageCrop> crops;
}
