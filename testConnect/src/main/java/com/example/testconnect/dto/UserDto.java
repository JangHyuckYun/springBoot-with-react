package com.example.testconnect.dto;

import com.example.testconnect.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private Long userId;

    private String loginId;

    private String loginPassword;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.loginId = user.getLoginId();
        this.loginPassword = user.getLoginPassword();
    }

    public User toEntity() {
        return User.builder().userId(userId).loginId(loginId).loginPassword(loginPassword).build();
    }
}
