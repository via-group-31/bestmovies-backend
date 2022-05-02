package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.UsersApi;
import com.group31.bestmovies.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class BestMoviesController implements UsersApi {

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        User user = new User();
        user.setName("Hello");
        user.setPassword("12345");
        return new ResponseEntity<>(Collections.singletonList(user), HttpStatus.OK);
    }
}
