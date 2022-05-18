package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Movie, Long> {
}
