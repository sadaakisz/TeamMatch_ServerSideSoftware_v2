package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Profile;
import com.teammatch.repository.PlayerRepository;
import com.teammatch.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public ResponseEntity<?> deleteProfile(Long profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
        profileRepository.delete(profile);
        return ResponseEntity.ok().build();
    }

    @Override
    public Profile updateProfile(Long profileId, Profile profileRequest) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
        profile.setFullName(profileRequest.getFullName());
        profile.setUsername(profileRequest.getUsername());
        profile.setDescription(profileRequest.getDescription());
        profile.setGender(profileRequest.getGender());
        profile.setEmail(profileRequest.getEmail());
        profile.setPhoneNumber(profileRequest.getPhoneNumber());
        profile.setBirthDate(profileRequest.getBirthDate());
        return profileRepository.save(profile);
    }

    @Override
    public Profile createProfile(Long playerId, Profile profile) {
        this.validatePlayer(playerId);
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile", "Id", profileId));
    }

    @Override
    public Profile getProfileByUsername(String username) {
        return profileRepository.findByUsername(username);
    }


    @Override
    public Page<Profile> getAllProfiles(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    public void validatePlayer(Long playerId) {
        if(!playerRepository.existsById(playerId)){
            throw new ResourceNotFoundException(
                    "Player not found with Id " + playerId
            );
        }
    }
}
