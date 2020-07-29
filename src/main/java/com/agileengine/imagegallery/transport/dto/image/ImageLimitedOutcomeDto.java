package com.agileengine.imagegallery.transport.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageLimitedOutcomeDto {

    private Long id;

    private byte[] content;

    private String imageName;
}
