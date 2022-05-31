package com.example.testconnect.service;

import com.example.testconnect.domain.User;
import com.example.testconnect.dto.UserDto;

import java.util.List;

public interface UserService {
    public Long save(UserDto dto);
    public User save(User user);
    public UserDto findUserById(Long id);
    public List<UserDto> findAllUser();
}
