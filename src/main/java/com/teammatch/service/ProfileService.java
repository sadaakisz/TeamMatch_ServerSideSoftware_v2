package com.teammatch.service;

import com.teammatch.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<?> deleteProfile(Long profileId);
    Profile updateProfile(Long profileId, Profile profileRequest);
    Profile createProfile(Profile profile);
    Profile getProfileById(Long profileId);
    Page<Profile> getAllProfiles(Pageable pageable);
}
