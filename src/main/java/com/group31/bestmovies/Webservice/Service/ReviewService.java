package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Review;
import com.group31.bestmovies.Repository.IReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@EnableCaching
public class ReviewService {

    private final IReviewRepository reviewRepository;

    @Cacheable("ratings")
    public Review getReviewById(long reviewId) {
        return reviewRepository.getById(reviewId);
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    public List<Review> getReviewByMovieId(long movieId) {
        return reviewRepository.getReviewByMovieId(movieId);
    }

    @Cacheable("ratings")
    public List<Review> getReviewByUserId(long userId) {
        return reviewRepository.getReviewByUserId(userId);
    }
}
