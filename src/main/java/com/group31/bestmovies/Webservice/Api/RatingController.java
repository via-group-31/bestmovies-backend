package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Webservice.Service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rating")
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<Rating> getRatingById(@RequestParam("ratingId") long ratingId){
        return ResponseEntity.ok().body(ratingService.getRatingById(ratingId));
    }

    /* TODO:
        GET ratings by movieId
    * */
}
