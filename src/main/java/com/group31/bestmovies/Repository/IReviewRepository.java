package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.reviews WHERE movie_id = :movieId", nativeQuery = true)
    List<Review> getReviewByMovieId(@Param("movieId") long movieId);

    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.reviews WHERE userId = :userId", nativeQuery = true)
    List<Review> getReviewByUserId(@Param("userId") long userId);
}
