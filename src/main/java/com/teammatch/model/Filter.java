package com.teammatch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name = "filters")
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String game;

    @NotNull
    private int minAge;

    @NotNull
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

    //One To One with Player and Team
    @OneToOne(mappedBy = "filter")
    @JsonIgnore
    private Player player;

    @OneToOne(mappedBy = "filter")
    @JsonIgnore
    private Team team;
}
