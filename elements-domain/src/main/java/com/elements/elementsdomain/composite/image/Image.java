package com.elements.elementsdomain.composite.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Image implements Serializable {
    private static final long serialVersionUID = 7498821317671661696L;
    private String fileName;
    private String key;
    private String uri;
    private Map<String, ImageCrop> crops;
}
