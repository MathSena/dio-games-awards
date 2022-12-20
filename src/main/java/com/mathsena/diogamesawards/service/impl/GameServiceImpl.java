package com.mathsena.diogamesawards.service.impl;

import com.mathsena.diogamesawards.models.Game;
import com.mathsena.diogamesawards.repository.GameRepository;
import com.mathsena.diogamesawards.service.GameService;
import com.mathsena.diogamesawards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repository;

    @Override
    public Game findById(Long id) {
        Optional<Game> game = repository.findById(id);
        return game.orElseThrow(NoContentException::new);

    }

    @Override
    public List<Game> findAll() {
        return repository.findAll();
    }

    @Override
    public void insert(Game game) {

    }

    @Override
    public void update(Long id, Game game) {

    }


    @Override
    public void delete(Game game) {

    }
}
