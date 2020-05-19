package com.example.movie.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Value("${api.key}")//injected value from properties file
    private String apiKey;

    public MovieListObj getMovieListInfo(String movieList) {
        Set<Integer> ids = new HashSet<>();
        List<Movie> movies = new ArrayList<>();

        Arrays.stream(movieList.split(","))
                .forEach(s -> ids.add(Integer.valueOf(s)));

        movieRepository.findAllById(ids).forEach(movies::add);

        System.err.println("api key: " + apiKey);

        return new MovieListObj(movies);
    }

    public Movie getMovieInfo(Integer movieId) {
        return movieRepository.findById(movieId).get();
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        System.err.println("api key: " + apiKey);

        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
}
