package com.springboot.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @Column(name = "platform_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Column(name = "platform_name")
    @NotNull(message = "The Platform name must not be null")
    @Size(min = 1,max = 100,message = "The Platform name size must be between 1-100 characters only")
    @Pattern(regexp = "[a-zA-Z0-9\\s]+",message = "The Platform name must contain only alphabets and numbers")
    @Getter @Setter
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_on_platforms",
            joinColumns = {@JoinColumn(name = "platform_platform_id")},
            inverseJoinColumns ={@JoinColumn(name = "movie_movie_id")})
    @Getter @Setter
    private List<Movie> availableMovies;

    public Platform() {
    }

    public Platform(String name) {
        this.name = name;
    }
}
