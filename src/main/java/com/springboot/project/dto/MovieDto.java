package com.springboot.project.dto;

import com.springboot.project.entity.Platform;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MovieDto {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Double rating;

    @Getter @Setter
    private String summary;

    @Getter @Setter
    private List<Platform> availablePlatforms;
}
