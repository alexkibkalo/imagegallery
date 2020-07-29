package com.agileengine.imagegallery.exception.user;


import com.agileengine.imagegallery.exception.standard.UnauthorizedException;

public class UserBadCredentialsException extends UnauthorizedException {

    public UserBadCredentialsException() {
        super("Invalid email or password");
    }

}
