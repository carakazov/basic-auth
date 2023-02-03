package com.baseauth.server.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.baseauth.server.dto.AddGameDto;
import com.baseauth.server.dto.GameDto;
import com.baseauth.server.model.Game;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GameMapping {
    public static Game fromAddGameDto(AddGameDto source) {
        return new Game()
            .setTitle(source.getTitle())
            .setDescription(source.getDescription())
            .setRating(source.getRating());
    }

    public static List<Game> fromAddGameDto(List<AddGameDto> source) {
        return source.stream()
            .map(GameMapping::fromAddGameDto)
            .collect(Collectors.toList());
    }

    public static GameDto toDto(Game source) {
        return new GameDto()
            .setId(source.getId())
            .setTitle(source.getTitle())
            .setDescription(source.getDescription())
            .setRating(source.getRating());
    }

    public static List<GameDto> toDto(List<Game> source) {
        return source.stream()
            .map(GameMapping::toDto)
            .collect(Collectors.toList());
    }
}
