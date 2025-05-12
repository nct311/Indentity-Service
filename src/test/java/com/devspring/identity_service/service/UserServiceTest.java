package com.devspring.identity_service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.devspring.identity_service.dto.request.UserCreationRequest;
import com.devspring.identity_service.dto.response.UserResponse;
import com.devspring.identity_service.entity.User;
import com.devspring.identity_service.exception.AppException;
import com.devspring.identity_service.repository.UserRepository;

@SpringBootTest
@TestPropertySource("/test.properties")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        dob = LocalDate.of(2004, 01, 31);

        request = UserCreationRequest.builder()
                .username("thanh123")
                .firstName("nguyen")
                .lastName("thanh")
                .password("12345678")
                .dob(dob)
                .build();
        userResponse = UserResponse.builder()
                .id("1")
                .username("thanh123")
                .firstName("nguyen")
                .lastName("thanh")
                .dob(dob)
                .build();

        user = User.builder()
                .id("1")
                .username("thanh123")
                .firstName("nguyen")
                .lastName("thanh")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() {
        // Given
        Mockito.when(userRepository.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(false);
        Mockito.when(userRepository.save(ArgumentMatchers.any())).thenReturn(user);

        // When
        var response = userService.createUser(request);

        // Then

        assertThat(response.getId()).isEqualTo("1");
        assertThat(response.getUsername()).isEqualTo("thanh123");
    }

    @Test
    void createUser_userExists_fail() {
        // Given
        Mockito.when(userRepository.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(true);

        // When
        var exception = assertThrows(AppException.class, () -> userService.createUser(request));

        // Then
        assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
    }

    @Test
    @WithMockUser(username = "thanh123")
    void getMyInfo_valid_success() {
        // Given
        Mockito.when(userRepository.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(user));

        var respone = userService.getMyInfo();

        assertThat(respone.getUsername()).isEqualTo("thanh123");
        assertThat(respone.getId()).isEqualTo("1");
    }

    @Test
    @WithMockUser(username = "thanh123")
    void getMyInfo_userNotFound_error() {
        // Given
        Mockito.when(userRepository.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(Optional.ofNullable(null));

        // When
        var exception = assertThrows(AppException.class, () -> userService.getMyInfo());

        assertThat(exception.getErrorCode().getCode()).isEqualTo(1005);
    }
}
