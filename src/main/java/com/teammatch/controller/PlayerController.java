package com.teammatch.controller;

import com.teammatch.model.Player;
import com.teammatch.resource.PlayerResource;
import com.teammatch.resource.SavePlayerResource;
import com.teammatch.service.PlayerService;
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
@CrossOrigin
@Tag(name = "Players", description = "Player API")
public class PlayerController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlayerService playerService;

    @Operation(summary = "Get all players.", description = "Gets all players by pages.", tags = { "players" })
    @GetMapping("/players")
    public Page<PlayerResource> getAllPlayers( Pageable pageable) {
        Page<Player> playersPage = playerService.getAllPlayers(pageable);
        List<PlayerResource> resources = playersPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Gets a player.", description = "Gets a particular player's information by its Id.",
            tags = { "players" })
    @GetMapping("/players/{id}")
    public PlayerResource getPlayerById(@PathVariable(name = "id") Long playerId) {
        return convertToResource(playerService.getPlayerById(playerId));
    }

    @Operation(summary = "Create a player.", description = "Creates a new player.", tags = { "players" })
    @PostMapping("/players")
    public PlayerResource createPlayer(@Valid @RequestBody SavePlayerResource resource)  {
        Player player = convertToEntity(resource);
        return convertToResource(playerService.createPlayer(player));
    }

    @Operation(summary = "Update a player.", description = "Updates a player's information, given its Id.",
            tags = { "players" })
    @PutMapping("/players/{id}")
    public PlayerResource updatePlayer(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SavePlayerResource resource) {
        Player player = convertToEntity(resource);
        return convertToResource(playerService.updatePlayer(playerId, player));
    }

    @Operation(summary = "Deletes a player.", description = "Deletes a particular player, given its Id.",
            tags = { "players" })
    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(name = "id") Long playerId) {
        return playerService.deletePlayer(playerId);
    }

    @GetMapping("/playersUsername/{username}")
    public PlayerResource getUserByUsername(@PathVariable(name = "username") String username) {
        return convertToResource(playerService.getPlayerByUsername(username));
    }

    @PostMapping("/login")
    public PlayerResource login(@Valid @RequestBody SavePlayerResource resource)  {
        Player player = convertToEntity(resource);
        return convertToResource(playerService.login(player));
    }

    private Player convertToEntity(SavePlayerResource resource) {
        return mapper.map(resource, Player.class);
    }

    private PlayerResource convertToResource(Player entity) {
        return mapper.map(entity, PlayerResource.class);
    }


}
