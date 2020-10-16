package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SaveFilterResource {

    @NotBlank
    @NotNull
    private String game;

    @NotBlank
    @NotNull
    private int age;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String region;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String gameStyle;

    @NotBlank
    @NotNull
    private int accountLevel;

    @NotBlank
    @NotNull
    private float rating;
}
