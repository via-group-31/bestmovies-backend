package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Rating;
import com.group31.bestmovies.Repository.IRatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@EnableCaching
public class RatingService {

    private final IRatingRepository ratingRepository;

    @Cacheable("ratings")
    public Rating getRatingById(long ratingId){
        return ratingRepository.getById(ratingId);
    }
    @Cacheable("ratings")
    public Rating getRatingsByMovieId(long movieID){return ratingRepository.getRatingByMovieId(movieID);}
}
