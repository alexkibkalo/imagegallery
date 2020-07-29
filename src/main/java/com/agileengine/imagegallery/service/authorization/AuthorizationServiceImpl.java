package com.agileengine.imagegallery.service.authorization;

import com.agileengine.imagegallery.configuration.security.properties.JWTProperties;
import com.agileengine.imagegallery.configuration.security.token.TokenHandler;
import com.agileengine.imagegallery.exception.user.UserBadCredentialsException;
import com.agileengine.imagegallery.exception.user.UserNotFoundException;
import com.agileengine.imagegallery.persistence.entity.token.Token;
import com.agileengine.imagegallery.persistence.entity.user.User;
import com.agileengine.imagegallery.service.token.TokenService;
import com.agileengine.imagegallery.service.user.UserService;
import com.agileengine.imagegallery.transport.dto.authorization.LoginDto;
import com.agileengine.imagegallery.transport.dto.token.TokenOutcomeDto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@Setter(onMethod_ = @Autowired)
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private TokenHandler tokenHandler;
    private TokenService tokenService;

    @Override
    public TokenOutcomeDto login(LoginDto loginDto) {
        User actor = userService.findByEmail(loginDto.getEmail());

        verification(actor);

        if (!passwordEncoder.matches(loginDto.getPassword(), actor.getPassword())) {
            throw new UserBadCredentialsException();
        }

        Instant tokenExpiration = Instant.now()
                .plus(
                        JWTProperties.EXPIRATION_TIME,
                        ChronoUnit.HOURS
                );

        String tokenValue = tokenHandler.generateAccessToken(actor);
        Token token = actor.getToken();

        if (token != null) {
            token.setToken(tokenValue);
            token.setExpiration(tokenExpiration);
        } else {
            token = new Token(
                    tokenExpiration,
                    tokenValue,
                    actor
            );
        }
        tokenService.create(token);

        TokenOutcomeDto dto = new TokenOutcomeDto();
        dto.setToken(token.getToken());

        return dto;
    }

    @Override
    public void logout() {
        User actor = getActorFromContext();
        tokenService.delete(tokenService.findByUser(actor).orElse(null));
    }

    public void verification(User actor) throws UserNotFoundException {
        if (actor.getDeleted()) {
            throw new UserNotFoundException();
        }
    }
}
