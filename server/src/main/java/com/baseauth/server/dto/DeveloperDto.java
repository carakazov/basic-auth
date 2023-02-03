package com.baseauth.server.dto;

import java.time.LocalDate;
import javax.annotation.sql.DataSourceDefinitions;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeveloperDto {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthdate;
}
