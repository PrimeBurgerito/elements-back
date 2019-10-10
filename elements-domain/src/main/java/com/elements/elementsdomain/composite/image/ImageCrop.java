package com.elements.elementsdomain.composite.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageCrop {
    private int x;
    private int y;
    private int width;
    private int height;
}
