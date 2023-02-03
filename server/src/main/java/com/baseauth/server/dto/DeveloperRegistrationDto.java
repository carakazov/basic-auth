package com.baseauth.server.dto;

import java.time.LocalDate;
import javax.annotation.sql.DataSourceDefinitions;

import lombok.Data;

@Data
public class DeveloperRegistrationDto {
    private String login;
    private String password;
    private String name;
    private String surname;
    private LocalDate birthDate;
}
