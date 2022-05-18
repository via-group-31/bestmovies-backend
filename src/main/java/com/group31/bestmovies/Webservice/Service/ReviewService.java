package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Review;
import com.group31.bestmovies.Repository.IReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {

    private final IReviewRepository reviewRepository;

    public Review getReviewById(long reviewId){
        return reviewRepository.getById(reviewId);
    }
}
