package com.springboot.project.dto;

import com.springboot.project.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PlatformDto {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private List<Movie> availableMovies;
}
