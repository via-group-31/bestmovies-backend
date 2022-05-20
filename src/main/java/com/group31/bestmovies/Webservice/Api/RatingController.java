package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Webservice.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<Rating> getRatingById(@RequestParam("ratingId") long ratingId) {
        return ResponseEntity.ok().body(ratingService.getRatingById(ratingId));
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getRatingsByMovieId(@PathVariable("movieId") long movieID) {
        return ResponseEntity.ok().body(ratingService.getRatingsByMovieId(movieID));
    }

    /* TODO:
        NEED TO TEST THIS
        GET ratings by movieId
    * */
}
