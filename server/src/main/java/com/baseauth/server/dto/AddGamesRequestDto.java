package com.baseauth.server.dto;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddGamesRequestDto {
    private List<AddGameDto> games;
}
