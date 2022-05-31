package com.example.testconnect.controller;

import com.example.testconnect.dto.UserDto;
import com.example.testconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    UserService userService;

    @GetMapping("hello")
    public List<String> hello() {

        return Arrays.asList("안녕하세요.", "Hello");
    }

    @PostMapping("saveUser")
    public Long saveUser(UserDto dto) {
        System.out.println(dto.getLoginId());
        System.out.println(dto.getLoginPassword());

        return userService.save(dto);
    }

    @GetMapping("getUser/{id}")
    public UserDto getUser(@PathVariable("id") Long userId) {

        return userService.findUserById(userId);
    }

    @GetMapping("getAllUser")
    public List<UserDto> getAllUser() {

        return userService.findAllUser();
    }
}
