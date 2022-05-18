package com.group31.bestmovies;

import com.group31.bestmovies.api.MovieApi;
import com.group31.bestmovies.api.MoviesApi;
import com.group31.bestmovies.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController implements MovieApi, MoviesApi {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ResponseEntity<Void> addMovieToMyList(Movie body) {
        return null;
    }

    @GetMapping("/movie")
    @ResponseBody
    public ResponseEntity<AnotherMovie> getMovie(@Param("movieID") String movieID) {
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
