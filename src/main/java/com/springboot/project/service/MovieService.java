package com.springboot.project.service;

import com.springboot.project.entity.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> findall();

    public Movie findById(int theId);

    public Movie save(Movie theMovie);

    public void delete(int theId);
}
