package com.teammatch.resource;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SaveFilterResource {

    @NotBlank
    @NotNull
    private String game;

    @NotNull
    @Min(value = 13, message = "Age should not be less than 13")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int minAge;

    @NotNull
    @Min(value = 13, message = "Age should not be less than 13")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int maxAge;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String region;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String country;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String gameStyle;

    @NotNull
    private int accountLevel;

    @NotNull
    private float rating;
}
