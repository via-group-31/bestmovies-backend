package com.group31.bestmovies.services;

import com.group31.bestmovies.models.Movie;
import com.group31.bestmovies.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieService {

    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(int movieID) {
        return movieRepository.getMovie(movieID);
    }
}
