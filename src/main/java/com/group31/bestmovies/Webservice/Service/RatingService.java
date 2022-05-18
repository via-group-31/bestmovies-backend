package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Repository.IRatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RatingService {

    private final IRatingRepository ratingRepository;

    public Rating getRatingById(long ratingId){
        return ratingRepository.getById(ratingId);
    }
}
