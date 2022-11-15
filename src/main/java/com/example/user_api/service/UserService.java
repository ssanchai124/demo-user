package com.example.user_api.service;


import com.example.user_api.controller.request.UserRequest;
import com.example.user_api.exception.UserDuplicateException;
import com.example.user_api.model.User;
import com.example.user_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(UserRequest userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());
        if (user == null) {
            user = new User().setUsername(userRequest.getUsername())
                    .setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                    .setRole(userRequest.getRole());

            return userRepository.save(user);
        }
        throw new UserDuplicateException(userRequest.getUsername());
    }


    public User findUserByUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}