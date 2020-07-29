package com.agileengine.imagegallery.exception.image;

import com.agileengine.imagegallery.exception.standard.NotFoundException;

public class ImageNotFoundException extends NotFoundException {

    public ImageNotFoundException() {
        super("Image not found");
    }
}
