package com.elements.elementsdomain.image;

import com.elements.elementsdomain.requirement.Requirement;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConditionalImage extends Image {

    private Requirement requirement;

    @Builder
    public ConditionalImage(String fileName, String key, String uri) {
        super(fileName, key, uri);
    }
}
