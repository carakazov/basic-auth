package com.baseauth.server.controller;

import com.baseauth.server.dto.auth.AuthRequestDto;
import com.baseauth.server.dto.auth.AuthResponseDto;
import com.baseauth.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    @PreAuthorize("permitAll()")
    public AuthResponseDto authenticate(@RequestBody AuthRequestDto authRequest) {
        return authService.authenticate(authRequest);
    }
}
