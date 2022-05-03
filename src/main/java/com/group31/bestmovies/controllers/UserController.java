package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.UserApi;
import com.group31.bestmovies.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    @Override
    public ResponseEntity<List<User>> login(String username, String password) {
        return null;
    }

    @Override
    public ResponseEntity<List<User>> register(String email, String username, String password) {
        return null;
    }
}
