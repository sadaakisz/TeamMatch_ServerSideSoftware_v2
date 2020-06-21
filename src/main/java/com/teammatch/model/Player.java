package com.teammatch.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String password;

    private int hours;

    //Relationship
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "profile_id", referencedColumnName = "id")
    //@JsonIgnore
    //private Profile profile;
}
