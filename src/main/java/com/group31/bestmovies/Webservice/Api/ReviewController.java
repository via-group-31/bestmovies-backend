package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Model.Review;
import com.group31.bestmovies.Model.UserModel;
import com.group31.bestmovies.Webservice.Service.ReviewService;
import com.group31.bestmovies.Webservice.Service.UserService;
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
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Review> getReviewById(@RequestParam("reviewId") long reviewId) {
        return ResponseEntity.ok().body(reviewService.getReviewById(reviewId));
    }

    @PostMapping
    public ResponseEntity addReview(@RequestBody Review reviewToAdd, @RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        reviewToAdd.setUserModel(user);
        reviewService.addReview(reviewToAdd);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Review>> getByMovieId(@PathVariable long movieId) {
        return ResponseEntity.ok().body(reviewService.getReviewByMovieId(movieId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getByUserId(@PathVariable long userId) {
        return ResponseEntity.ok().body(reviewService.getReviewByUserId(userId));
    }
}
