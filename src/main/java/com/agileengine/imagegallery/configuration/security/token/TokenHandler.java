package com.agileengine.imagegallery.configuration.security.token;

import com.agileengine.imagegallery.configuration.security.properties.JWTProperties;
import com.agileengine.imagegallery.persistence.entity.user.User;
import com.agileengine.imagegallery.persistence.entity.user.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Configuration
@PropertySource("classpath:application.yml")
public class TokenHandler {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public Optional<Long> getUserId(@NonNull String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(JWTProperties.SECRET)
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();

            return Optional.of(Long.valueOf((Integer) body.get("userId")));

        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .claim("role", takeRole(user))
                .claim("create", Instant.now().toString())
                .claim("expiration", Instant.now().plus(JWTProperties.EXPIRATION_TIME, ChronoUnit.HOURS).toEpochMilli())
                .claim("userId", user.getId())
                .signWith(SignatureAlgorithm.HS512, JWTProperties.SECRET)
                .compact();
    }

    @SuppressWarnings("unchecked")
    private UserRole takeRole(User user) {
        return ((List<UserRole>) user.getAuthorities()).get(0);
    }

}
