package com.baseauth.server.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baseauth.server.dto.AddGameDto;
import com.baseauth.server.dto.AddGamesRequestDto;
import com.baseauth.server.dto.GamesListResponseDto;
import com.baseauth.server.mapper.GameMapping;
import com.baseauth.server.model.Developer;
import com.baseauth.server.model.Game;
import com.baseauth.server.repository.impl.GameRepository;
import com.baseauth.server.service.AuthService;
import com.baseauth.server.service.DeveloperService;
import com.baseauth.server.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService  {
    private final GameRepository repository;
    private final AuthService authService;
    private final DeveloperService developerService;

    @Override
    public GamesListResponseDto save(AddGamesRequestDto addGameDto) {
        List<Game> games = GameMapping.fromAddGameDto(addGameDto.getGames());
        List<Game> savedGames = games.stream()
            .map(repository::save)
            .collect(Collectors.toList());

        Developer developer = developerService.findByLogin(authService.getLogin());

        developer.getGames().addAll(savedGames);

        return new GamesListResponseDto()
            .setGames(GameMapping.toDto(savedGames));
    }

    @Override
    public GamesListResponseDto getGamesOfDeveloper(Integer id) {
        Developer developer = developerService.findById(id);
        return new GamesListResponseDto().setGames(GameMapping.toDto(developer.getGames()));
    }
}
