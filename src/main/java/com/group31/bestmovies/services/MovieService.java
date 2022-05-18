package com.group31.bestmovies.services;

import com.group31.bestmovies.models.Movie;
import com.group31.bestmovies.repositories.IMovieRepository;
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

    public Movie getMovie(int movieID) {
        return movieRepository.getMovie(movieID);
    }
}
