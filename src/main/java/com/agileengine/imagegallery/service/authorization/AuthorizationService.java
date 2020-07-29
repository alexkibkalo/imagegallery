package com.agileengine.imagegallery.service.authorization;

import com.agileengine.imagegallery.service.actor.ActorService;
import com.agileengine.imagegallery.transport.dto.authorization.LoginDto;
import com.agileengine.imagegallery.transport.dto.token.TokenOutcomeDto;

public interface AuthorizationService extends ActorService {

    TokenOutcomeDto login(LoginDto loginDto);

    void logout();

}
