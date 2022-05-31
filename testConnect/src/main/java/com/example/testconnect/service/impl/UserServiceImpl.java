package com.example.testconnect.service.impl;

import com.example.testconnect.domain.User;
import com.example.testconnect.dto.UserDto;
import com.example.testconnect.repository.UserRepository;
import com.example.testconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public Long save(UserDto dto) {
        return userRepository.save(dto.toEntity()).getUserId();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public UserDto findUserById(Long id) {
        return userRepository.findById(id).map(UserDto::new).get();
    }

    public List<UserDto> findAllUser() {

        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }
}
