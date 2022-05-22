package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUserEmail(String userEmail);

    @Modifying
    @Query(value = "INSERT INTO Movies.dbo.movielist (user_id, movie_id) values (:userId, :movieId)", nativeQuery = true)
    void addMovieToFavorites(@Param("userId") long userId, @Param("movieId") long movieId);

    @Modifying
    @Query(value = "DELETE FROM Movies.dbo.movielist WHERE user_id=:userId AND movie_id=:movieId", nativeQuery = true)
    void deleteMovieFromFavorites(@Param("userId") long userId, @Param("movieId") long movieId);
}
