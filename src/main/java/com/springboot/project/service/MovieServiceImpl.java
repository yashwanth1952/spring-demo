package com.springboot.project.service;

import com.springboot.project.dao.MovieRepository;
import com.springboot.project.entity.Movie;
import com.springboot.project.exception.MovieNameAlreadyExists;
import com.springboot.project.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findall() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int theId) {
        Optional<Movie> result = movieRepository.findById(theId);

        Movie movie=null;
        if(result.isPresent()){
            movie=result.get();
        }
        else{
            throw new MovieNotFoundException("Did not find movie with id = "+theId);
        }
        return movie;
    }

    @Override
    public Movie save(Movie theMovie) {

        try{
            movieRepository.save(theMovie);
        }catch (Exception exception){

            throw new MovieNameAlreadyExists("The Movie Name "+theMovie.getName()+" is already used ." +
                    "Please use New Movie Name");
        }
        return theMovie;
    }

    @Override
    public void delete(int theId) {

        movieRepository.deleteById(theId);
    }
}
