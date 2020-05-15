package com.example.movie.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;


    public MovieListObj getMovieListInfo(String movieList) {
        Set<Integer> ids = new HashSet<>();
        List<Movie> movies = new ArrayList<>();

        Arrays.stream(movieList.split(","))
                .forEach(s -> ids.add(Integer.valueOf(s)));

        movieRepository.findAllById(ids).forEach(movies::add);


        return new MovieListObj(movies);
    }

    public Movie getMovieInfo(Integer movieId) {
        return movieRepository.findById(movieId).get();
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
}
