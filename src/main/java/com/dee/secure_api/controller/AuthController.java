package com.dee.secure_api.controller;

import com.dee.secure_api.dto.ApiResponse;
import com.dee.secure_api.dto.UserData;
import com.dee.secure_api.dto.UserRegisReq;
import com.dee.secure_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> register(@RequestBody UserRegisReq dto) {
        ApiResponse<?> response = authService.registeruser(dto);
        return ResponseEntity.ok(response);
    }

}
