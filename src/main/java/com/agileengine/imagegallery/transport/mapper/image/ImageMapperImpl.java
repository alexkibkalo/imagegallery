package com.agileengine.imagegallery.transport.mapper.image;

import com.agileengine.imagegallery.persistence.entity.image.Image;
import com.agileengine.imagegallery.transport.dto.image.ImageLimitedOutcomeDto;
import com.agileengine.imagegallery.transport.dto.image.ImageOutcomeDto;
import org.springframework.stereotype.Service;

@Service
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageLimitedOutcomeDto toLimitedDto(Image image) {

        ImageLimitedOutcomeDto dto = new ImageLimitedOutcomeDto();

        if (image != null) {
            dto.setId(image.getId());
            dto.setContent(image.getContent());
            dto.setImageName(image.getImageName());
        }

        return dto;    }

    @Override
    public ImageOutcomeDto toDto(Image image) {

        ImageOutcomeDto dto = new ImageOutcomeDto();

        if (image != null) {
            dto.setId(image.getId());
            dto.setContent(image.getContent());
            dto.setBetterResolution(image.getBetterResolution());
            dto.setHashtags(image.getHashtags());
            dto.setPhotographerName(image.getPhotographerName());
            dto.setImageName(image.getImageName());
        }

        return dto;
    }
}
