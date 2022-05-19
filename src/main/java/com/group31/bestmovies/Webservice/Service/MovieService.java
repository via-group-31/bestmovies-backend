package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<Movie> getMoviesWithSimilarName(String name) {
        return movieRepository.getMoviesWithSimilarName(name);
    }

    public Movie getMovieById(long movieId) {
        return movieRepository.getById(movieId);
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }
}
