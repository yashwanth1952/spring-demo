package com.springboot.project.service;

import com.springboot.project.dao.MovieRepository;
import com.springboot.project.entity.Movie;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
class MovieServiceImplTest {

     @Autowired
     private MovieService movieService;

     @MockBean
     private MovieRepository movieRepository;

     @Test
     void findall_should_Return2_when_2ElementsArePresentInList() {
         List<Movie> tempList=new ArrayList<>();

         tempList.add(new Movie("Ram",6.7,"summary"));
         tempList.add(new Movie("Sam",6.7,"summary"));

         Mockito.when(movieRepository.findAll()).thenReturn(tempList);

         assertEquals(2,movieService.findall().size());
     }

     @Test
     void findById_should_returnTheMovieWithMatchingId() {
         int id=1;
         Movie movie=new Movie(1,"Ram",6.7,"summary");
         Optional<Movie> optionalMovie=Optional.ofNullable(movie);
         Mockito.when(movieRepository.findById(id)).thenReturn(optionalMovie);

        MatcherAssert.assertThat(movieService.findById(id),is(movie));
    }



     @Test
     void save_should_returnMovie_when_saved() {
         Movie movie=new Movie("Ram",6.7,"summary");

         Mockito.when(movieRepository.save(movie)).thenReturn(movie);

         Assert.assertEquals(movie,movieService.save(movie));
     }


    @Test
    void delete_should_visitRepository1Time_when_anElementIsDeleted() {
        int id=1;
        Movie movie=new Movie(1,"Avengers",9.8,"Avengers Summary");
        movieService.delete(id);
        verify(movieRepository,times(1)).deleteById(id);
    }

}

