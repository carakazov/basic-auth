package com.baseauth.server.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.baseauth.server.model.Developer;
import com.baseauth.server.repository.impl.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final String USER_ROLE = "ROLE_CUSTOM";

    private final DeveloperRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<Developer> developers = repository.getAll();
        Developer developer = developers.stream()
            .filter(item -> username.equals(item.getLogin()))
            .findFirst()
            .orElse(null);

        if(Objects.isNull(developer)) {
            throw new UsernameNotFoundException("Login not found");
        }

        return new User(
            username,
            developer.getPassword(),
            Set.of(new SimpleGrantedAuthority(USER_ROLE))
        );
    }
}
