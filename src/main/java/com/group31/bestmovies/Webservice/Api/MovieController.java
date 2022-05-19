package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Webservice.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<Movie> getMovieById(@RequestParam("movieId") long movieId) {
        return ResponseEntity.ok().body(movieService.getMovieById(movieId));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok().body(movieService.getMovies());
    }

    @GetMapping("/movies/{movieName}")
    public ResponseEntity<List<Movie>> getMoviesWithSimilarName(@PathVariable String movieName) {
        return ResponseEntity.ok().body(movieService.getMoviesWithSimilarName(movieName));
    }
}
