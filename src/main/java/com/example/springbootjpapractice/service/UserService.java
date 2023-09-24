package com.example.springbootjpapractice.service;

import com.example.springbootjpapractice.domain.User;
import com.example.springbootjpapractice.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);

        return user;
    }

}
