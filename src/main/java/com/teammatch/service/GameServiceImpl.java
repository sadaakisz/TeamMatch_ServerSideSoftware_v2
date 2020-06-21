package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Game;
import com.teammatch.model.Profile;
import com.teammatch.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService{
    @Autowired
    private GameRepository gameRepository;

    @Override
    public ResponseEntity<?> deleteGame(Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "Id", gameId));
        gameRepository.delete(game);
        return ResponseEntity.ok().build();
    }

    @Override
    public Game updateGame(Long gameId, Game gameRequest) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "Id", gameId));
        game.setName(gameRequest.getName());
        game.setGameTeamSize(gameRequest.getGameTeamSize());
        return gameRepository.save(game);
    }

    @Override
    public Game createGame(Game game) { return gameRepository.save(game); }

    @Override
    public Game getGameById(Long gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new ResourceNotFoundException("Game", "Id", gameId));
    }

    @Override
    public Page<Game> getAllGames(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }
}
