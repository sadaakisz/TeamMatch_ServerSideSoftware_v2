package com.teammatch.controller;

import com.teammatch.model.Team;
import com.teammatch.resource.SaveTeamResource;
import com.teammatch.resource.TeamResource;
import com.teammatch.service.TeamService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
@Tag(name = "Teams", description = "Team API")
public class TeamController {
    @Autowired
    ModelMapper mapper;
    @Autowired
    TeamService teamService;

    @PostMapping("/teams/")
    public TeamResource createTeam(@RequestBody @Valid SaveTeamResource resource){
        Team team = convertToEntity(resource);
        return convertToResource(teamService.createTeam(team));
    }

    @GetMapping("/teams/{id}")
    public TeamResource getTeamById(@PathVariable(name = "id") Long teamId){
        return convertToResource(teamService.getTeamById(teamId));
    }

    @GetMapping("/teams/")
    public Page<TeamResource> getAllTeams(Pageable pageable){
        Page<Team> teamsPage = teamService.getAllTeams(pageable);
        List<TeamResource> resources = teamsPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PutMapping("/teams/{id}")
    public TeamResource updateTeam(@PathVariable(name = "id") Long teamId, @Valid @RequestBody SaveTeamResource resource){
        Team team = convertToEntity(resource);
        return convertToResource(teamService.updateTeam(teamId, team));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(name = "id") Long teamId){
        return teamService.deleteTeam(teamId);
    }

    private TeamResource convertToResource(Team entity){
        return mapper.map(entity, TeamResource.class);
    }

    private Team convertToEntity(SaveTeamResource resource){
        return mapper.map(resource, Team.class);
    }
}
