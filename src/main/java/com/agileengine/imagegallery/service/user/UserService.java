package com.agileengine.imagegallery.service.user;

import com.agileengine.imagegallery.persistence.entity.user.User;
import com.agileengine.imagegallery.service.actor.ActorService;

import java.util.Optional;

public interface UserService extends ActorService {

    User findByEmail(String email);

    Optional<User> findById(Long id);

    User findByIdUnsafe(Long id);

}
