package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Player;
import com.teammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;

@Service
public class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
    }

    @Override
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Player createPlayer(Player player) {
        Date last_connection = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String string_last_connection = formatter.format(last_connection);
        player.setLast_connection(string_last_connection);
        return playerRepository.save(player);
    }

    @Override
    public ResponseEntity<?> deletePlayer(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
        playerRepository.delete(player);
        return ResponseEntity.ok().build();
    }

    @Override
    public Player updatePlayer(Long playerId, Player playerRequest) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));
        player.setUsername(playerRequest.getUsername());
        player.setPassword(playerRequest.getPassword());
        player.setHours(playerRequest.getHours());
        return playerRepository.save(updateLastConnection(player.getId()));
    }

    @Override
    public Player getPlayerByUsername(String username){
        Player myplayer = playerRepository.findByUsername(username);
        if(myplayer == null){
            Player player = new Player();
            return player;
        }
        else{
            return myplayer;
        }
    }

    @Override
    public Player login(Player playerRequest) {
        Player myPlayer = playerRepository.findByUsername(playerRequest.getUsername());
        if(myPlayer == null){
            return playerRequest;
        }
        if(playerRequest.getPassword().equals(myPlayer.getPassword())){
            return updateLastConnection(myPlayer.getId());
        }
        return playerRequest;
    }

    @Override
    public Player updateLastConnection(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "Id", playerId));

        Date last_connection = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String string_last_connection = formatter.format(last_connection);
        player.setLast_connection(string_last_connection);
        return playerRepository.save(player);
    }
}
