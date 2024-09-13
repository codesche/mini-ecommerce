package com.kosta.controller;

import com.kosta.domain.user.*;
import com.kosta.service.UserService;
import com.kosta.util.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenUtils tokenUtils;

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponse> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        // 토큰 요청
        Map<String, String> tokenMap = userService.refreshToken(request);

        // 토큰 재발급 불가인 경우 401 에러 반환
        if (tokenMap == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // 헤더 Cookie로 refresh 토큰 재발급
        tokenUtils.setRefreshTokenCookie(response, tokenMap.get("refreshToken"));

        // 응답 Body로 access 토큰 재발급
        return ResponseEntity.ok(LoginResponse.builder()
                .accessToken(tokenMap.get("refreshToken"))
                .build());
    }

    // 회원가입
    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        log.info("[signUp] 회원가입 진행. 요청정보 : {}", signUpRequest);
        UserResponse userResponse = userService.signUp(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    // 회원 전체 리스트
    @GetMapping("")
    public ResponseEntity<List<UserResponse>> getUserList() {
        log.info("[getUserList] 회원 전체 조회");
        List<UserResponse> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }

    // 이메일 중복 확인
    @GetMapping("/duplicate")
    public ResponseEntity<Boolean> emailCheck(@RequestParam("email") String email) {
        boolean isNotDuplicate = userService.duplicateCheckEmail(email);
        return ResponseEntity.ok(isNotDuplicate);
    }

    // 회원 정보 수정
    @PatchMapping("")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        log.info("[updatedUser] 회원 정보 수정. 수정 요청 정보 : {}", userUpdateRequest);
        UserResponse userResponse = userService.updateUser(userUpdateRequest);
        return ResponseEntity.ok(userResponse);
    }

    // 회원 정보 삭제
    @DeleteMapping("")
    public ResponseEntity<?> userWithdrawal(@RequestBody UserDeleteRequest userDeleteRequest) {
        log.info("[userWithdrawal] 회원 삭제. 삭제 요청 정보 : {}", userDeleteRequest);
        userService.deleteUser(userDeleteRequest);
        return ResponseEntity.ok(null);
    }

}
