package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MovieService {

    private final IMovieRepository movieRepository;

    public Movie getMovieById(long movieId){
        return movieRepository.getById(movieId);
    }
}
