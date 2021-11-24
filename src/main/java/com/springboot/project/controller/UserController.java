package com.springboot.project.controller;

import com.springboot.project.dto.MovieDto;
import com.springboot.project.dto.MovieMapper;
import com.springboot.project.dto.PlatformDto;
import com.springboot.project.dto.PlatformMapper;
import com.springboot.project.service.MovieService;
import com.springboot.project.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private PlatformService platformService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,"age",stringTrimmerEditor);
    }

    @GetMapping("/movie-list")
    public String showMovies(Model model){

        List<MovieDto> movies= MovieMapper.INSTANCE.toDtos(movieService.findall());

        model.addAttribute("movies",movies);

        return "user-movies-list";
    }

    @GetMapping("/platform-list")
    public String showPlatforms(Model model){


        List<PlatformDto> platforms= PlatformMapper.INSTANCE.toDtos(platformService.findall());

        model.addAttribute("platforms",platforms);

        return "user-platforms-list";
    }

    @GetMapping("/showMovieInfo")
    public String showMovieInfo(@RequestParam("movieId") int id,Model model){


        MovieDto movie= MovieMapper.INSTANCE.toDto(movieService.findById(id));

        model.addAttribute("movie",movie);

        return "user-movie-info";
    }
}
