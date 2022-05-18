package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.MovieApi;
import com.group31.bestmovies.api.MoviesApi;
import com.group31.bestmovies.models.*;
import com.group31.bestmovies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController implements MovieApi, MoviesApi {
    private final MovieService movieService;

    @Override
    public ResponseEntity<Void> addMovieToMyList(Movie body) {
        return null;
    }

    @Override
    public ResponseEntity<Movie> getMovie(String movieID) {
        return new ResponseEntity<>(movieService.getMovie(Integer.parseInt(movieID)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Movie>> getMyMovieList() {
        Movie newMovie = new Movie();
        newMovie.setMovieID(1);
        newMovie.setTitle("Indiana Jones");
        newMovie.setYear(1875);
        ArrayList arrayList = new ArrayList();
        arrayList.add(newMovie);
        return new ResponseEntity<>(arrayList, HttpStatus.OK);
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
