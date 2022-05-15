package com.group31.bestmovies.controllers;

import com.group31.bestmovies.api.StarApi;
import com.group31.bestmovies.api.StarsApi;
import com.group31.bestmovies.models.Star;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarController implements StarsApi, StarApi {
    @Override
    public ResponseEntity<Star> getStar(String starID) {
        return null;
    }

    @Override
    public ResponseEntity<List<Star>> getStars() {
        return null;
    }
}
