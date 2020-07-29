package com.agileengine.imagegallery.service.user;

import com.agileengine.imagegallery.exception.user.UserBadCredentialsException;
import com.agileengine.imagegallery.exception.user.UserNotFoundException;
import com.agileengine.imagegallery.persistence.entity.user.User;
import com.agileengine.imagegallery.persistence.repository.UserRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Setter(onMethod_ = @Autowired)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(UserBadCredentialsException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByIdUnsafe(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}