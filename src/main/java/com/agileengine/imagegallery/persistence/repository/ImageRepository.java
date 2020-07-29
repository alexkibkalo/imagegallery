package com.agileengine.imagegallery.persistence.repository;

import com.agileengine.imagegallery.persistence.entity.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
