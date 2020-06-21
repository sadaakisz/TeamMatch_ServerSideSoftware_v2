package com.teammatch.resource;

import lombok.Data;

import java.util.Date;
@Data
public class ProfileResource {
    private Long id;
    private String fullName;
    private String username;
    private String description;
    private String gender;
    private String email;
    private String phoneNumber;
    private Date birthDate;
}
