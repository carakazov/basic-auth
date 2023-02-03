package com.baseauth.server.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDto {
    private Integer id;
    private String title;
    private Float rating;
    private String description;
}
