package com.agileengine.imagegallery.service.image;

import com.agileengine.imagegallery.exception.image.ImageNotFoundException;
import com.agileengine.imagegallery.persistence.entity.image.Image;
import com.agileengine.imagegallery.persistence.repository.ImageRepository;
import com.agileengine.imagegallery.transport.dto.image.ImageLimitedOutcomeDto;
import com.agileengine.imagegallery.transport.dto.image.ImageOutcomeDto;
import com.agileengine.imagegallery.transport.mapper.image.ImageMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableScheduling
@Transactional
@Setter(onMethod_ = @Autowired)
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private ImageMapper imageMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ImageLimitedOutcomeDto> getAll(Pageable pageable) {
        return imageRepository.findAll(pageable).map(imageMapper::toLimitedDto);
    }

    @Override
    @Transactional(readOnly = true)
    public ImageOutcomeDto getById(Long id) {
        Image image = imageRepository.findById(id).orElseThrow(ImageNotFoundException::new);
        return imageMapper.toDto(image);
    }

    @Scheduled(initialDelay = 30000L, fixedDelay = 60000L)
    public void clearCache(){
        imageRepository.deleteAll();
        System.out.println("Cache cleared");
    }
}
