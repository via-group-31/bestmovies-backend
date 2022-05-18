package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<MovieModel, Long> {
    List<MovieModel> findAllByMovieName(String movieName);
}
