package com.agileengine.imagegallery.service.image;

import com.agileengine.imagegallery.transport.dto.image.ImageLimitedOutcomeDto;
import com.agileengine.imagegallery.transport.dto.image.ImageOutcomeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {

    Page<ImageLimitedOutcomeDto> getAll(Pageable pageable);

    ImageOutcomeDto getById(Long id);

}