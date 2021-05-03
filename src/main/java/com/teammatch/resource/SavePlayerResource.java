package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SavePlayerResource {
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String password;

    @NotNull
    @NotBlank
    private int hours;

    @NotNull
    @NotBlank
    private String last_connection;
}
