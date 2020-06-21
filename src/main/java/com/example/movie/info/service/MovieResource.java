package com.example.movie.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieResource {

    @Autowired
    private MovieService movieService;


    @RequestMapping("/movies")
    public List<Movie> getMovies(){
        return  movieService.getAllMovies();
    }

    @RequestMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId){
        return  movieService.getMovieInfo(movieId);
    }

    @RequestMapping("/movies/list/{movieList}")
    public MovieListObj getMovieListInfo(@PathVariable("movieList") String movieList){
        return  movieService.getMovieListInfo(movieList);
    }

    @RequestMapping("/")
    String root(){
        return "Hi there, Movie Info Service is online!<br>please check swagger-ui.html# for available commands";
    }
}
