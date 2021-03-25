package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveTeamResource {
    @NotNull
    @NotBlank
    private String teamName;

    @NotBlank
    @NotNull
    private int teamSize;

    @NotBlank
    @NotNull
    float average;

    @NotBlank
    @NotNull
    float hoursPlayed;
}
