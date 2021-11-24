package com.springboot.project.dto;

import com.springboot.project.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE= Mappers.getMapper(MovieMapper.class);

    MovieDto toDto(Movie movie);

    List<MovieDto> toDtos(List<Movie> movies);

    Movie toEntity(MovieDto movieDto);
}
