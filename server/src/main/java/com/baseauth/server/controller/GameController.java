package com.baseauth.server.controller;

import com.baseauth.server.dto.AddGamesRequestDto;
import com.baseauth.server.dto.GamesListResponseDto;
import com.baseauth.server.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService service;

    @PostMapping
    @Secured("ROLE_CUSTOM")
    public GamesListResponseDto addGames(@RequestBody AddGamesRequestDto request) {
        return service.save(request);
    }

    @GetMapping("/{id}")
    @Secured("ROLE_CUSTOM")
    public GamesListResponseDto getGamesOfDeveloper(@PathVariable Integer id) {
        return service.getGamesOfDeveloper(id);
    }
}
