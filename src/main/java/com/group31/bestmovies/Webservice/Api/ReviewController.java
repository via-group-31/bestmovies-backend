package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Model.Review;
import com.group31.bestmovies.Webservice.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Review> getReviewById(@RequestParam("reviewId") long reviewId) {
        return ResponseEntity.ok().body(reviewService.getReviewById(reviewId));
    }

    @PostMapping
    public ResponseEntity addReview(@RequestBody Review reviewToAdd) {
        reviewService.addReview(reviewToAdd);
        return ResponseEntity.ok().build();
    }

    @GetMapping("movie/{movieId}")
    public ResponseEntity<List<Review>> getByMovieId(@PathVariable long movieId) {
        return ResponseEntity.ok().body(reviewService.getReviewByMovieId(movieId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Review>> getByUserId(@PathVariable long userId) {
        return ResponseEntity.ok().body(reviewService.getReviewByUserId(userId));
    }
}
