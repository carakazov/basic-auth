package com.baseauth.server.service;

import com.baseauth.server.dto.auth.AuthRequestDto;
import com.baseauth.server.dto.auth.AuthResponseDto;

public interface AuthService {
    AuthResponseDto authenticate(AuthRequestDto request);

    String getLogin();
}
