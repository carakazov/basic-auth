package com.baseauth.server.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Game {
    private Integer id;
    private String title;
    private Float rating;
    private String description;
}
