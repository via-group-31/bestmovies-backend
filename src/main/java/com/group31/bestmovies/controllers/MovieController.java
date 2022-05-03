package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.MovieApi;
import com.group31.bestmovies.api.MoviesApi;
import com.group31.bestmovies.api.UserApi;
import com.group31.bestmovies.models.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieController implements MovieApi, MoviesApi {

    @Override
    public ResponseEntity<Void> addMovieToMyList(Movie body) {
        return null;
    }

    @Override
    public ResponseEntity<Movie> getMovie(String movieID) {
        return null;
    }

    @Override
    public ResponseEntity<List<Movie>> getMyMovieList() {
        return null;
    }

    @Override
    public ResponseEntity<Void> myMovieList(List<Movie> body) {
        return null;
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        return null;
    }
}
