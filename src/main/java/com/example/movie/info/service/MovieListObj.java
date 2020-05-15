package com.example.movie.info.service;

import java.util.List;

public class MovieListObj {

    private List<Movie> movies;

    public MovieListObj(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieListObj() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
