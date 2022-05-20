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
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserModel userModel) {
        userService.registerUser(userModel);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/favorites")
    public ResponseEntity addMoviesToFavorite(@RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        userService.addMoviesToFavorites(499549, user.getUserId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/favorites")
    public ResponseEntity deleteMoviesFromFavorites(@RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        userService.removeMoviesFromFavorites(499549, user.getUserId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/favorites")
    public ResponseEntity<List<Movie>> getFavoritesByUserId(@RequestHeader("Authorization") String token) {
        UserModel user = userService.getUserFromHeader(token);
        if(user == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().body(userService.getFavoritesByUserId(user.getUserId()));
    }
}
