package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Movie;
import com.group31.bestmovies.Repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<Movie> getMoviesWithSimilarName(String name) {
        return movieRepository.getMoviesWithSimilarName(name);
    }

    public Movie getMovieById(long movieId) {
        return movieRepository.getById(movieId);
    }

    public List<Movie> getMovies() {
        List<Movie> movies = movieRepository.getMovies();

        RestTemplate restTemplate = new RestTemplate();

        for(Movie movie: movies){
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

            movie.setMoviePoster(poster);
        }

        return movies;
    }
}
