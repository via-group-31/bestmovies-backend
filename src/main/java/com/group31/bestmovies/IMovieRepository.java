package com.group31.bestmovies;

import com.group31.bestmovies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<AnotherMovie, Integer> {

    @Query(value = "SELECT * FROM Movies.dbo.movies WHERE id = :movieID", nativeQuery = true)
    AnotherMovie getMovie(@Param("movieID") int movieID);
}
