package com.baseauth.server.service;

import com.baseauth.server.dto.AddGameDto;
import com.baseauth.server.dto.AddGamesRequestDto;
import com.baseauth.server.dto.GamesListResponseDto;
import com.baseauth.server.model.Game;

public interface GameService {
    GamesListResponseDto save(AddGamesRequestDto addGameDto);

    GamesListResponseDto getGamesOfDeveloper(Integer id);
}
