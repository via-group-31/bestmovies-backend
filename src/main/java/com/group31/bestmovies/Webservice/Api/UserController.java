package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Model.UserModel;
import com.group31.bestmovies.Webservice.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserModel userModel) {
        userService.registerUser(userModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("favorites")
    public ResponseEntity addMoviesToFavorite(@RequestBody List<Movie> moviesToAdd, @RequestParam("userId") long userId) {
        userService.addMoviesToFavorites(moviesToAdd, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("favorites")
    public ResponseEntity deleteMoviesFromFavorites(@RequestBody List<Movie> moviesToRemove, @RequestParam("userId") long userId) {
        userService.removeMoviesFromFavorites(moviesToRemove, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("favorites")
    public ResponseEntity<List<Movie>> getFavoritesByUserId(@RequestParam("userId") long userId) {
        return ResponseEntity.ok().body(userService.getFavoritesByUserId(userId));
    }
}
