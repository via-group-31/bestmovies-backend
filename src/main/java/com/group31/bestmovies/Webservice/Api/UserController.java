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

    @PostMapping("/favorites")
    public ResponseEntity addMoviesToFavorite(@RequestBody List<Movie> moviesToAdd, @RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        userService.addMoviesToFavorites(moviesToAdd, user.getUserId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/favorites")
    public ResponseEntity deleteMoviesFromFavorites(@RequestBody List<Movie> moviesToRemove, @RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        userService.removeMoviesFromFavorites(moviesToRemove, user.getUserId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Movie>> getFavoritesByUserId(@RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().body(userService.getFavoritesByUserId(user.getUserId()));
    }
}
