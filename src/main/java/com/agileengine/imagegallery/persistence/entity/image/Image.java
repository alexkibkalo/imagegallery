package com.agileengine.imagegallery.persistence.entity.image;

import com.agileengine.imagegallery.persistence.entity.general.IdEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Image extends IdEntity {

    @Column(columnDefinition = "BYTEA")
    private byte[] content;

    @Column(nullable = false)
    private String imageName;

    @Column(nullable = false)
    private String photographerName;

    private String betterResolution;

    private String hashtags;
}
