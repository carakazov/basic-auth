package com.baseauth.server.service.impl;

import java.util.Objects;

import com.baseauth.server.dto.auth.AuthRequestDto;
import com.baseauth.server.dto.auth.AuthResponseDto;
import com.baseauth.server.execption.AuthenticationException;
import com.baseauth.server.filter.JwtProvider;
import com.baseauth.server.model.Developer;
import com.baseauth.server.repository.impl.DeveloperRepository;
import com.baseauth.server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final DeveloperRepository developerRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {
        Developer developer = developerRepository.getAll().stream()
            .filter(item -> request.getLogin().equals(item.getLogin()))
            .findFirst()
            .orElse(null);
        if(Objects.nonNull(developer) && passwordEncoder.matches(request.getPassword(), developer.getPassword())) {
            return new AuthResponseDto().setToken(jwtProvider.generateToken(developer));
        }
        throw new AuthenticationException("Wrong credentials");
    }

    @Override
    public String getLogin() {
        String token = SecurityContextHolder.getContext().getAuthentication().getDetails().toString();
        return jwtProvider.getLoginFromToken(token);
    }
}
