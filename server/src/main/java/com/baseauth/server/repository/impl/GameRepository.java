package com.baseauth.server.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.baseauth.server.model.Game;
import com.baseauth.server.repository.GenericRepository;
import org.springframework.stereotype.Component;

@Component
public class GameRepository implements GenericRepository<Game> {
    private static final Set<Game> GAMES = new HashSet<>();
    private static Integer ID_COUNTER = 0;

    @Override
    public Set<Game> getAll() {
        return Set.copyOf(GAMES);
    }

    @Override
    public Game getById(Integer id) {
        return GAMES.stream()
            .filter(item -> id.equals(item.getId()))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Game save(Game object) {
        ID_COUNTER++;
        object.setId(ID_COUNTER);
        GAMES.add(object);
        return object;
    }

    @Override
    public void delete(Integer id) {
        Game game = getById(id);
        GAMES.remove(game);
    }
}
