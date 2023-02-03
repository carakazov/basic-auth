package com.baseauth.server.service;

import com.baseauth.server.dto.DeveloperDto;
import com.baseauth.server.dto.DeveloperRegistrationDto;
import com.baseauth.server.dto.DevelopersListResponseDto;
import com.baseauth.server.model.Developer;

public interface DeveloperService {
    DeveloperDto register(DeveloperRegistrationDto registrationDto);

    Developer findByLogin(String login);

    Developer findById(Integer id);

    DevelopersListResponseDto getAllDevelopers();
}
