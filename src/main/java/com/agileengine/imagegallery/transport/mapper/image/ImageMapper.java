package com.agileengine.imagegallery.transport.mapper.image;

import com.agileengine.imagegallery.persistence.entity.image.Image;
import com.agileengine.imagegallery.transport.dto.image.ImageLimitedOutcomeDto;
import com.agileengine.imagegallery.transport.dto.image.ImageOutcomeDto;

public interface ImageMapper {

    ImageOutcomeDto toDto(Image image);

    ImageLimitedOutcomeDto toLimitedDto(Image image);
}
