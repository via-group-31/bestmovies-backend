package com.group31.bestmovies.repositories;

import com.group31.bestmovies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM databaseName WHERE movieId= :movieId ", nativeQuery = true)
    Movie getMovie(@Param("movieId") Integer movieId);
}
