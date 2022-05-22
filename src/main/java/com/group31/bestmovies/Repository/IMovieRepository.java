package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.movies", nativeQuery = true)
    List<Movie> getMovies();

    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.movies where title LIKE %:movieName%", nativeQuery = true)
    List<Movie> getMoviesWithSimilarName(@Param("movieName") String movieName);

    @Query(value = "SELECT * FROM Movies.dbo.movies WHERE id IN (SELECT movie_id FROM Movies.dbo.movielist WHERE user_id = :userId)", nativeQuery = true)
    List<Movie> getAllFavoriteMoviesByUserId(long userId);
}
