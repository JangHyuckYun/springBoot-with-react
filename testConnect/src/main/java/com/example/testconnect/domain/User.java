package com.example.testconnect.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name="user")
@Getter
@ToString(callSuper = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "login_password")
    private String loginPassword;

    @Builder
    public User(Long userId, String loginId, String loginPassword) {

        this.userId = userId;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
    }


}
