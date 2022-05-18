package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByMovieName(String movieName);
}
