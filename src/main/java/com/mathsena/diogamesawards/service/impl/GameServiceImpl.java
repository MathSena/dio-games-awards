package com.mathsena.diogamesawards.service.impl;

import com.mathsena.diogamesawards.models.Game;
import com.mathsena.diogamesawards.repository.GameRepository;
import com.mathsena.diogamesawards.service.GameService;
import com.mathsena.diogamesawards.service.exception.BusinessException;
import com.mathsena.diogamesawards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        if(Objects.isNull(game.getId())){
            throw new BusinessException("O ID é diferente de Null na inclusão!");

        }
        repository.save(game);

    }

    @Override
    public void update(Long id, Game game) {
        Game gameDb = findById(id);
        if(gameDb.getId() == (game.getId())) {
            repository.save(game);
        }else {
            throw new BusinessException("Os IDs para alteração são divergentes!");
        }

    }


    @Override
    public void delete(Long id) {
        Game gameDb = findById(id);
        repository.delete(gameDb);


    }
}
