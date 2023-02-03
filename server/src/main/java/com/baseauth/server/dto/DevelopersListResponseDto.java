package com.baseauth.server.dto;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DevelopersListResponseDto {
    private List<DeveloperDto> developers;
}
