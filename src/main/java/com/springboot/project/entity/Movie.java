package com.springboot.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Column(name = "movie_name")
    @NotNull(message = "The Movie name must not be null")
    @Size(min = 1,max = 100,message = "The Movie name size must be between 1-100 characters only")
    @Getter @Setter
    private String name;

    @Column(name = "movie_rating")
    @NotNull(message = "The rating must not be null")
    @DecimalMin(value = "0.1",message = "The rating must be greater than 0")
    @DecimalMax(value = "10",message = "The rating must be lesser than 10")
    @Getter @Setter
    private Double rating;

    @Column(name = "movie_summary")
    @NotNull(message = "The Movie summary must not be null")
    @Size(min = 1,max = 300,message = "The Movie summary size must be between 1-300 characters only")
    @Getter @Setter
    private String summary;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_on_platforms",
            joinColumns = @JoinColumn(name = "movie_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_platform_id"))
    @Getter @Setter
    private List<Platform> availablePlatforms;

    public Movie() {
    }

    public Movie(String name, Double rating, String summary) {
        this.name = name;
        this.rating = rating;
        this.summary = summary;
    }

    public Movie(int id, String name, Double rating, String summary) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.summary = summary;
    }
}
