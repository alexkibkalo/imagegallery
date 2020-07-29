package com.agileengine.imagegallery.exception.user;


import com.agileengine.imagegallery.exception.standard.NotFoundException;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("User not found");
    }
}
