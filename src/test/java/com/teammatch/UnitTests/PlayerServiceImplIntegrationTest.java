package com.teammatch.tournament.UnitTests;

import com.teammatch.tournament.TournamentApplication;
import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.repository.PlayerRepository;
import com.teammatch.tournament.domain.service.PlayerService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import com.teammatch.tournament.service.PlayerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;


@ExtendWith(SpringExtension.class)
public class PlayerServiceImplIntegrationTest extends TournamentApplicationTests{

    @Autowired
    private PlayerService playerService;

    @MockBean
    private PlayerRepository playerRepository;

    @TestConfiguration
    static class PlayerServiceImplConfiguration{
        @Bean
        public PlayerService playerService(){ return new PlayerServiceImpl();}
    }

    @Test
    @DisplayName("When findById But Id Does Not Exists Return player not found for Id with value 1")
    public void whenFindByIdButIdDoesNotExistsReturnPlayerNotFound(){
        //Arrange
        String response = "Resource %s not found for %s with value %s";
        Player player = new Player();
        player.setId(1L).setFirstName("Diego").setLastName("Johnson");

        Mockito.when(playerRepository.findById(1L))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Player","Id", player.getId());
        //Act
        Throwable exception = catchThrowable(()-> {
            Player result = playerService.getPlayerById(1L);
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

}
