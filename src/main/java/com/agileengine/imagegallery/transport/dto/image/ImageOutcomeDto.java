package com.agileengine.imagegallery.transport.dto.image;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageOutcomeDto {

    private Long id;

    private byte[] content;

    private String imageName;

    private String photographerName;

    private String betterResolution;

    private String hashtags;

}
