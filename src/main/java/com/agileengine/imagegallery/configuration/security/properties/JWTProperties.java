package com.agileengine.imagegallery.configuration.security.properties;

public class JWTProperties {

    public static final String SECRET = "SECURITY";
    public static final Long EXPIRATION_TIME = 86400000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
