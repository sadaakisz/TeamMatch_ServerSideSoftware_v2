package com.teammatch.tournament.UnitTests;

import com.teammatch.tournament.TournamentApplication;
import com.teammatch.tournament.domain.model.Player;
import com.teammatch.tournament.domain.model.Team;
import com.teammatch.tournament.domain.repository.PlayerRepository;
import com.teammatch.tournament.domain.service.PlayerService;
import com.teammatch.tournament.domain.service.TeamService;
import com.teammatch.tournament.exception.ResourceNotFoundException;
import com.teammatch.tournament.service.TeamServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(SpringExtension.class)
public class TeamServiceImplIntegrationTest extends TournamentApplicationTests{
    @Autowired
    private TeamService teamService;

    @MockBean
    private PlayerRepository playerRepository;

    @TestConfiguration
    static class TeamServiceImplTestConfiguration {
        @Bean
        public TeamService teamService() {
            return new TeamServiceImpl();
        }
    }
    @Test
    @DisplayName("When assignTeamPlayer But Player Not Exists Return Player not found for Id with value 1")
    public void  whenAssignTeamPlayerButPlayerNotExistsReturnPlayerNotFound() {
        String response = "Resource %s not found for %s with value %s";
        Player player = new Player();
        player.setId(1L).setFirstName("Diego").setLastName("Johnson");

        Mockito.when(playerRepository.findById(player.getId()))
                .thenReturn(Optional.empty());

        String expectedMessage = String.format(response, "Player","Id", player.getId());
        //Act
        Team team = new Team();
        team.setId(1L);
        Throwable exception = catchThrowable(()-> {
            Team result = teamService.assignTeamPlayer(team.getId(),player.getId());
        });
        //Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }

}
