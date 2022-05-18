package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Webservice.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieByName(@RequestParam("movieName") String movieName){
        return ResponseEntity.ok().body(movieService.getMoviesByName(movieName));
    }

    @GetMapping("/byid")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("movieId") long movieId){
        return ResponseEntity.ok().body(movieService.getMovieById(movieId));
    }
}
