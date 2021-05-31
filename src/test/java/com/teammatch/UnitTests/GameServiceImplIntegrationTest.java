package com.teammatch.UnitTests;

import com.teammatch.TeammatchApplicationTest;
import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Game;
import com.teammatch.repository.GameRepository;
import com.teammatch.service.GameService;
import com.teammatch.service.GameServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class GameServiceImplIntegrationTest extends TeammatchApplicationTest {
    @MockBean
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @TestConfiguration
    public static class GameServiceImplConfiguration {
        @Bean
        public GameService gameService(){
            return new GameServiceImpl();
        }
    }

    @Test
    @DisplayName("When getGameById but id does not exist return game not found for id with value 1")
    public void whenGetGameByIdButIdDoesNotExistReturnPlayerNotFound(){
        String response = "Resource %s not found for %s with value %s";
        Game game = new Game();
        game.setId(1L);
        game.setName("Apex Legends");
        game.setGameTeamSize(3);

        Mockito.when(gameRepository.findById(1L)).thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Game", "Id", game.getId());

        Throwable exception = catchThrowable(() -> {
            Game result = gameService.getGameById(1L);
        });

        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }

}
