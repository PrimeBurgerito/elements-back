package com.elements.elementsdomain.shared.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageCrop implements Serializable {
    private static final long serialVersionUID = 69224148889840834L;
    private int x;
    private int y;
    private int width;
    private int height;
}
