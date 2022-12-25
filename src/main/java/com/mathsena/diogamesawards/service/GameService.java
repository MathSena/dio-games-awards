package com.mathsena.diogamesawards.service;

import com.mathsena.diogamesawards.models.Game;

import java.util.List;

public interface GameService {

    Game findById(Long id);

    List<Game> findAll();
    void insert(Game game);
    void update(Long id, Game game);
    void delete(Long id);
}
