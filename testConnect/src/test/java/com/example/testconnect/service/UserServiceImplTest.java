package com.example.testconnect.service;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.example.testconnect.domain.User;
import com.example.testconnect.repository.UserRepository;
import com.example.testconnect.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    // @spy = 실제 객체의 스파이를 생성해 실제 객체의 메소드를 호출 할 수 있게 해줌
    // @Mock = 테스트할 때 필요한 실제 객체와 동일한 모의 객체를 만들어줌
    // @InjectMock = @Mock이나 @Spy로 생성된 mock 객체를 자동으로 주입해주는 어노테이션입니다

    // @Nested =

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Nested
    @DisplayName("유저 생성")
    class CreateUser {
        private String loginId;
        private String loginPassword;

        @BeforeEach
        void setUp() {
            loginId = "user";
            loginPassword = "user1234";
        }

        @Nested
        @DisplayName("비정상 케이스")
        class FailCase {
            @Test
            @DisplayName("반환된 유저 데이터가 Null인 경우")
            void createUserFail1() {
                //given
                User user = User.builder().loginId(loginId).loginPassword(loginPassword).build();
                when(userRepository.save(any())).thenReturn(null);

                // when
                User result = userService.save(user);

                // then
                assertThat(result, is(nullValue()));
            }
        }

        @Nested
        @DisplayName("정상 케이스")
        class SuccessCase {
            @Test
            @DisplayName("새로운 유저 생성")
            void createUserSuccess1() {
                //give
                User user = User.builder().loginId(loginId).loginPassword(loginPassword).build();

                when(userRepository.save(any())).thenReturn(user);

                //when
                User result = userService.save(user);

                //then
                verify(userRepository, times(1)).save(any());
                assertThat(result, equalTo(user));
            }
        }

    }
}
