package com.springboot.project.controller;

import com.springboot.project.dto.*;
import com.springboot.project.entity.Movie;
import com.springboot.project.entity.Platform;
import com.springboot.project.service.MovieServiceImpl;
import com.springboot.project.service.PlatformServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private PlatformServiceImpl platformService;

    String movieForm="movie-form";

    String platformForm="platform-form";

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/movie-list")
    public String showMovieList(Model model){

        List<MovieDto> movies= MovieMapper.INSTANCE.toDtos(movieService.findall());

        model.addAttribute("movies",movies);

        return "admin-movies-list";
    }

    @GetMapping("/platform-list")
    public String showPlatformList(Model model){

        List<PlatformDto> platforms=PlatformMapper.INSTANCE.toDtos(platformService.findall());

        model.addAttribute("platforms",platforms);

        return "admin-platforms-list";
    }

    @GetMapping("/movie-form")
    public String showMovieForm(Model model){

        MovieDto movie=MovieMapper.INSTANCE.toDto(new Movie());

        model.addAttribute("movie",movie);

        List<PlatformDto> platforms=PlatformMapper.INSTANCE.toDtos(platformService.findall());

        model.addAttribute("platforms",platforms);

        return movieForm;
    }

    @GetMapping("/platform-form")
    public String showPlatformForm(Model model){

        PlatformDto platform=PlatformMapper.INSTANCE.toDto(new Platform());

        model.addAttribute("platform",platform);

        return platformForm;
    }

    @GetMapping("/movieUpdateForm")
    public String showMovieUpdateForm(@RequestParam("movieId") int id, Model model){

        MovieDto movie=MovieMapper.INSTANCE.toDto(movieService.findById(id));

        model.addAttribute("movie",movie);

        List<PlatformDto> platforms=PlatformMapper.INSTANCE.toDtos(platformService.findall());

        model.addAttribute("platforms",platforms);

        return movieForm;
    }

    @GetMapping("/platformUpdateForm")
    public String showPlatformUpdateForm(@RequestParam("platformId") int id, Model model){

        PlatformDto platform=PlatformMapper.INSTANCE.toDto(platformService.findById(id));

        model.addAttribute("platform",platform);

        return platformForm;
    }

    @GetMapping("/movieDelete")
    public String movieDelete(@RequestParam("movieId") int id){

        movieService.delete(id);

        return "redirect:/admin/movie-list";
    }

    @GetMapping("/platformDelete")
    public String platformDelete(@RequestParam("platformId") int id){

        platformService.delete(id);

        return "redirect:/admin/platform-list";
    }

    @PostMapping("/movieSave")
    public String movieSave(@Valid @ModelAttribute("movie")Movie movie,
                            BindingResult result, Model model){

        if(result.hasErrors()){

            List<PlatformDto> platforms=PlatformMapper.INSTANCE.toDtos(platformService.findall());

            model.addAttribute("platforms",platforms);

            return movieForm;
        }
        movieService.save(movie);

        return "redirect:/admin/movie-list";

    }

    @PostMapping("/platformSave")
    public String platformSave(@Valid @ModelAttribute("platform") Platform platform, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return platformForm;
        }

        platformService.save(platform);

        return "redirect:/admin/platform-list";

    }

}
