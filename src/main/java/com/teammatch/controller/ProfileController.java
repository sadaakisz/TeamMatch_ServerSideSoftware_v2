package com.teammatch.controller;

import com.teammatch.resource.ProfileResource;
import com.teammatch.resource.SaveProfileResource;
import com.teammatch.service.PlayerService;
import com.teammatch.service.ProfileService;
import org.modelmapper.ModelMapper;
import com.teammatch.model.Profile;
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
@RequestMapping("/api/players")

public class ProfileController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("{id}/profiles")
    public ProfileResource getProfileByPlayerId(@PathVariable(name = "id") Long playerId) {
        return convertToResource(profileService.getProfileById(playerId));
    }

    @PostMapping("{id}/profiles")
    public ProfileResource createProfile(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SaveProfileResource resource)  {
        Profile profile = convertToEntity(resource);
        profile.setId(playerId);
        return convertToResource(profileService.createProfile(profile));
    }

    @PutMapping("{id}/profiles")
    public ProfileResource updateProfile(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SaveProfileResource resource) {
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.updateProfile(playerId, profile));
    }

    @DeleteMapping("{id}/profiles")
    public ResponseEntity<?> deleteProfile(@PathVariable(name = "id") Long profileId) {
        return profileService.deleteProfile(profileId);
    }

    private Profile convertToEntity(SaveProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }

    private ProfileResource convertToResource(Profile entity) {
        return mapper.map(entity, ProfileResource.class);
    }
}
