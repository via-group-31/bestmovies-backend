package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@EnableCaching
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<Movie> getMoviesWithSimilarName(String name) {
        List<Movie> movies = movieRepository.getMoviesWithSimilarName(name);
        for(Movie movie: movies){
            movie.setMoviePoster(getMoviePosters(movie));
        }
        return movies;
    }

    public Movie getMovieById(long movieId) {
        Movie movie = movieRepository.getById(movieId);
        movie.setMoviePoster(getMoviePosters(movie));
        return movie;
    }

    @Cacheable("movies")
    public List<Movie> getMovies() {
        System.out.println("Getting from database");
        List<Movie> movies = movieRepository.getMovies();

        for(Movie movie: movies){
            movie.setMoviePoster(getMoviePosters(movie));
        }

        return movies;
    }

    private String getMoviePosters(Movie movie){
        RestTemplate restTemplate = new RestTemplate();

        String movieId = String.format("%07d", movie.getMovieId());

        String uri = "https://www.omdbapi.com/?apikey=c3d1f671&i=tt" + movieId;
        String imdb = restTemplate.getForObject(uri, String.class);

        final String regex = ",\"Poster\":\"(.*?)\"";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(imdb);

        String poster = "";

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                poster = matcher.group(1);
            }
        }

        return poster;
    }
}
