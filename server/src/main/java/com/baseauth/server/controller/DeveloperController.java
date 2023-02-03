package com.baseauth.server.controller;

import com.baseauth.server.dto.DeveloperDto;
import com.baseauth.server.dto.DeveloperRegistrationDto;
import com.baseauth.server.dto.DevelopersListResponseDto;
import com.baseauth.server.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/developer")
public class DeveloperController {
    private final DeveloperService service;

    @PostMapping
    @PreAuthorize("permitAll()")
    public DeveloperDto register(@RequestBody DeveloperRegistrationDto developer) {
        return service.register(developer);
    }


    @GetMapping
    @Secured("ROLE_CUSTOM")
    public DevelopersListResponseDto getAllDevelopers() {
        return service.getAllDevelopers();
    }
}
