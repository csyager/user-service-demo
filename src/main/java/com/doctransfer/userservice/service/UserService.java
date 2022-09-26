package com.doctransfer.userservice.service;

import com.doctransfer.userservice.exception.UserNotFoundException;
import com.doctransfer.userservice.model.User;
import com.doctransfer.userservice.model.request.CreateUserRequest;
import com.doctransfer.userservice.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserJpaRepository userRepository;

    UserService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
