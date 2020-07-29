package com.agileengine.imagegallery.service.token;


import com.agileengine.imagegallery.persistence.entity.token.Token;
import com.agileengine.imagegallery.persistence.entity.user.User;

import java.util.Optional;

public interface TokenService {

    Token getByToken(String substring);

    void create(Token token);

    Optional<Token> findByUser(User user);

    void delete(Token token);

    void extendExpiration(Token token);
}
