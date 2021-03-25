package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Team;
import com.teammatch.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long teamId) {
        return teamRepository.findById(teamId).
                orElseThrow(() -> new ResourceNotFoundException("Team", "Id", teamId));
    }

    @Override
    public Team updateTeam(Long teamId, Team teamRequest) {
        Team team = teamRepository.findById(teamId).
                orElseThrow(() -> new ResourceNotFoundException("Team", "Id", teamId));
        team.setAverage(teamRequest.getAverage());
        team.setHoursPlayed(teamRequest.getAverage());
        team.setTeamName(teamRequest.getTeamName());
        team.setTeamSize(teamRequest.getTeamSize());
        return teamRepository.save(team);
    }

    @Override
    public ResponseEntity<?> deleteTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).
                orElseThrow(() -> new ResourceNotFoundException("Team", "Id", teamId));
        teamRepository.delete(team);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<Team> getAllTeams(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }
}
