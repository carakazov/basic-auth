package com.baseauth.server.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.baseauth.server.dto.DeveloperDto;
import com.baseauth.server.dto.DeveloperRegistrationDto;
import com.baseauth.server.model.Developer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DeveloperMapper {
    public static Developer fromRegistrationDto(DeveloperRegistrationDto source) {
        return new Developer()
            .setLogin(source.getLogin())
            .setPassword(source.getPassword())
            .setName(source.getName())
            .setSurname(source.getSurname())
            .setBirthDate(source.getBirthDate());
    }

    public static DeveloperDto toDto(Developer developer) {
        return new DeveloperDto()
            .setId(developer.getId())
            .setName(developer.getName())
            .setSurname(developer.getSurname())
            .setBirthdate(developer.getBirthDate());
    }

    public static List<DeveloperDto> toDto(Set<Developer> developer) {
        return developer.stream()
            .map(DeveloperMapper::toDto)
            .collect(Collectors.toList());
    }
}
