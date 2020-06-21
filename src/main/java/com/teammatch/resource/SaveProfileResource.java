package com.teammatch.resource;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Data

public class SaveProfileResource {
    @NotBlank
    @NotNull
    @Size(max = 20)
    private String fullName;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String username;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String description;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String gender;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private Date birthDate;
}
