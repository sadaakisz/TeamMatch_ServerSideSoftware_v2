package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveGameResource {
    @NotBlank
    @NotNull
    @Size(max = 20)
    private String name;
    
    @NotNull
    private int gameTeamSize;
}
