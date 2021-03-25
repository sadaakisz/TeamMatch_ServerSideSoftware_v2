package com.teammatch.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResource {
    private Long id;
    private String teamName;
    private int teamSize;
    float average;
    float hoursPlayed;
}
