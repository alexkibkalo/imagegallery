package com.agileengine.imagegallery.service.token;

import com.agileengine.imagegallery.configuration.security.properties.JWTProperties;
import com.agileengine.imagegallery.exception.standard.BadRequestException;
import com.agileengine.imagegallery.persistence.entity.token.Token;
import com.agileengine.imagegallery.persistence.entity.user.User;
import com.agileengine.imagegallery.persistence.repository.TokenRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class TokenServiceImpl implements TokenService {

    private TokenRepository tokenRepository;

    @Override
    @Transactional(readOnly = true)
    public Token getByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void create(Token token) {
        tokenRepository.save(token);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Token> findByUser(User user) {
        return tokenRepository.findByUser(user);
    }

    @Override
    public void delete(Token token) {
        if(token != null){
            tokenRepository.delete(token);
        } else {
            throw new BadRequestException("Login first");
        }
    }

    @Override
    public void extendExpiration(Token token) {
        Instant tokenExpiration = Instant.now()
                .plus(
                        JWTProperties.EXPIRATION_TIME,
                        ChronoUnit.HOURS
                );

        if (token != null) {
            token.setExpiration(tokenExpiration);
            tokenRepository.save(token);
        }
    }
}
