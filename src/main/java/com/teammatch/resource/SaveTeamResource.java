package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveTeamResource {
    @NotNull
    @NotBlank
    private String teamName;

    @NotNull
    private int teamSize;

    @NotNull
    float average;

    @NotNull
    float hoursPlayed;
}
