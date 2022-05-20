package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.ratings WHERE movie_id = :movieId", nativeQuery = true)
    Rating getRatingByMovieId(@Param("movieId") long movieId);
}
