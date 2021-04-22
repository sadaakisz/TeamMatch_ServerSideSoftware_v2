package com.teammatch.controller;

import com.teammatch.model.Game;
import com.teammatch.model.Player;
import com.teammatch.resource.GameResource;
import com.teammatch.resource.PlayerResource;
import com.teammatch.resource.SaveGameResource;
import com.teammatch.resource.SavePlayerResource;
import com.teammatch.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Tag(name = "Games", description = "Game API")
public class GameController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private GameService gameService;

    @Operation(summary = "Get all games", description = "Get all games by pages", tags = { "games" })
    @GetMapping("/games")
    public Page<GameResource> getAllGames(Pageable pageable) {
        Page<Game> gamesPage = gameService.getAllGames(pageable);
        List<GameResource> resources = gamesPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Gets the information of a game.", description = "Get a particular game by its Id.",
            tags = { "games" })
    @GetMapping("/games/{id}")
    public GameResource getGameById(@PathVariable(name = "id") Long gameId) {
        return convertToResource(gameService.getGameById(gameId));
    }

    @Operation(summary = "Create game.", description = "Creates a new game.", tags = { "games" })
    @PostMapping("/games")
    public GameResource createGame(@Valid @RequestBody SaveGameResource resource)  {
        Game game = convertToEntity(resource);
        return convertToResource(gameService.createGame(game));
    }

    @Operation(summary = "Update a game", description = "Updates a particular game's information, given its Id.",
            tags = { "games" })
    @PutMapping("/games/{id}")
    public GameResource updateGame(@PathVariable(name = "id") Long gameId, @Valid @RequestBody SaveGameResource resource) {
        Game game = convertToEntity(resource);
        return convertToResource(gameService.updateGame(gameId, game));
    }

    @Operation(summary = "Deletes a game.", description = "Deletes a particular game, given its Id.",
            tags = { "games" })
    @DeleteMapping("/games/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable(name = "id") Long gameId) {
        return gameService.deleteGame(gameId);
    }
    private Game convertToEntity(SaveGameResource resource) {
        return mapper.map(resource, Game.class);
    }

    private GameResource convertToResource(Game entity) {
        return mapper.map(entity, GameResource.class);
    }
}
