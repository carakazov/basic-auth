package com.baseauth.server.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.baseauth.server.dto.DeveloperDto;
import com.baseauth.server.dto.DeveloperRegistrationDto;
import com.baseauth.server.dto.DevelopersListResponseDto;
import com.baseauth.server.execption.LoginAlreadyExistsException;
import com.baseauth.server.mapper.DeveloperMapper;
import com.baseauth.server.model.Developer;
import com.baseauth.server.repository.impl.DeveloperRepository;
import com.baseauth.server.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DeveloperDto register(DeveloperRegistrationDto registrationDto) {

        if(Objects.nonNull(findByLogin(registrationDto.getLogin()))) {
            throw new LoginAlreadyExistsException("Login exists");
        }

        Developer developer = DeveloperMapper.fromRegistrationDto(registrationDto);
        developer.setPassword(passwordEncoder.encode(developer.getPassword()));
        return DeveloperMapper.toDto(repository.save(developer));
    }

    @Override
    public Developer findByLogin(String login) {
        return repository.getAll().stream()
            .filter(item -> login.equals(item.getLogin()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Developer findById(Integer id) {
        return repository.getById(id);
    }

    @Override
    public DevelopersListResponseDto getAllDevelopers() {
        Set<Developer> developers = repository.getAll();
        return new DevelopersListResponseDto().setDevelopers(DeveloperMapper.toDto(developers));
    }
}
