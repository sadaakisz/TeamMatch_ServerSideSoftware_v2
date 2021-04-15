package com.teammatch.controller;

import com.teammatch.model.Player;
import com.teammatch.resource.PlayerResource;
import com.teammatch.resource.SavePlayerResource;
import com.teammatch.service.PlayerService;
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
@Tag(name = "Players", description = "Player API")
public class PlayerController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public Page<PlayerResource> getAllPlayers( Pageable pageable) {
        Page<Player> playersPage = playerService.getAllPlayers(pageable);
        List<PlayerResource> resources = playersPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/players/{id}")
    public PlayerResource getPlayerById(@PathVariable(name = "id") Long playerId) {
        return convertToResource(playerService.getPlayerById(playerId));
    }

    @PostMapping("/players")
    public PlayerResource createPlayer(@Valid @RequestBody SavePlayerResource resource)  {
        Player player = convertToEntity(resource);
        return convertToResource(playerService.createPlayer(player));
    }

    @PutMapping("/players/{id}")
    public PlayerResource updatePlayer(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SavePlayerResource resource) {
        Player player = convertToEntity(resource);
        return convertToResource(playerService.updatePlayer(playerId, player));
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(name = "id") Long playerId) {
        return playerService.deletePlayer(playerId);
    }


    private Player convertToEntity(SavePlayerResource resource) {
        return mapper.map(resource, Player.class);
    }

    private PlayerResource convertToResource(Player entity) {
        return mapper.map(entity, PlayerResource.class);
    }


}
