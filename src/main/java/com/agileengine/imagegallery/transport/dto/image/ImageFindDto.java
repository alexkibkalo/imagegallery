package com.agileengine.imagegallery.transport.dto.image;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ImageFindDto {

    private String imageName;

    private String photographerName;

    private String betterResolution;

    private String hashtags;
}
