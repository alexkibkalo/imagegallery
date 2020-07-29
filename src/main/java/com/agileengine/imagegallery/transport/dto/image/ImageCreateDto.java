package com.agileengine.imagegallery.transport.dto.image;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ImageCreateDto {

    @NotNull
    @NotBlank
    private byte[] content;

    @NotNull
    @NotBlank
    private String imageName;

    @NotNull
    @NotBlank
    private String photographerName;

    private String betterResolution;

    private String hashtags;
}
