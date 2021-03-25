package com.teammatch.resource;

import lombok.Data;

@Data
public class FilterResource {
    private long id;
    private String game;
    private int minAge;
    private int maxAge;
    private String region;
    private String country;
    private String gameStyle;
    private int accountLevel;
    private float rating;
}
