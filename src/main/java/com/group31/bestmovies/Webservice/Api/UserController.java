package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Model.UserModel;
import com.group31.bestmovies.Webservice.Service.MovieService;
import com.group31.bestmovies.Webservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final MovieService movieService;

    @PostMapping("/auth/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserModel userModel) {
        userService.registerUser(userModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/favorites")
    public ResponseEntity addMoviesToFavorite(@RequestHeader("Authorization") String token, @RequestParam("movieId") Long movieId) {
        UserModel user = userService.getUserFromHeader(token);
        if (user == null)
            return ResponseEntity.badRequest().build();

        userService.addMoviesToFavorites(user.getUserId(), movieId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/favorites")
    public ResponseEntity deleteMoviesFromFavorites(@RequestHeader("Authorization") String token, @RequestParam("movieId") Long movieId) {
        UserModel user = userService.getUserFromHeader(token);
        if (user == null)
            return ResponseEntity.badRequest().build();

        userService.removeMoviesFromFavorites(user.getUserId(), movieId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/favorites")
    public ResponseEntity<List<Movie>> getFavoritesByUserId(@RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if (user == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().body(movieService.getFavoritesByUserId(user.getUserId()));
    }

    @GetMapping("/user/favoritesList")
    public ResponseEntity<Void> isInFavorites(@RequestHeader("Authorization") String token, @RequestParam long movieId) {
        UserModel user = userService.getUserFromHeader(token);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        if (user.getMovieList().stream().noneMatch(m -> m.getMovieId() == movieId)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
