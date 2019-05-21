package com.elements.elementsdomain.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Image {
    private String fileName;
    private String key;
    private String uri;
}
