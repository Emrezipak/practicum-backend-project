package com.spring.project.service;

import com.spring.project.entity.User;
import com.spring.project.repository.ProductRepository;
import com.spring.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User save(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getUserByUserId(Long userId){
      return userRepository.findById(userId);
    }
}
