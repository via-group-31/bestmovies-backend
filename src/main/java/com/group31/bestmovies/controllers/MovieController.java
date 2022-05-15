package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.MovieApi;
import com.group31.bestmovies.api.MoviesApi;
import com.group31.bestmovies.api.UserApi;
import com.group31.bestmovies.models.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
        Movie newMovie = new Movie();
        newMovie.setMovieID(1);
        newMovie.setTitle("Indiana Jones");
        newMovie.setYear(1875);
        ArrayList arrayList = new ArrayList();
        arrayList.add(newMovie);
        return new ResponseEntity<>(arrayList,HttpStatus.OK);
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
