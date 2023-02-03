package com.baseauth.server.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Developer {
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private List<Game> games = new ArrayList<>();
}
