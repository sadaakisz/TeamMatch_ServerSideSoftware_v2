package com.teammatch.resource;

import lombok.Data;

@Data
public class FilterResource {
    private long id;
    private String game;
    private int age;
    private String region;
    private String gameStyle;
    private int accountLevel;
    private float rating;
}
