package com.kosta.service;

import com.kosta.domain.user.SignUpRequest;
import com.kosta.domain.user.UserDeleteRequest;
import com.kosta.domain.user.UserResponse;
import com.kosta.domain.user.UserUpdateRequest;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserResponse signUp(SignUpRequest signUpRequest);

    List<UserResponse> getUserList();

    Map<String, String> refreshToken(HttpServletRequest request);

    boolean duplicateCheckEmail(String email);

    UserResponse updateUser(UserUpdateRequest userUpdateRequest);

    void deleteUser(UserDeleteRequest userDeleteRequest);

}
