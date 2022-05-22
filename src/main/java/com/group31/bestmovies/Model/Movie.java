package com.group31.bestmovies.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies", schema = "dbo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
    @Id
    @Column(name = "id")
    private long movieId;

    @Column(name = "title")
    private String movieName;

    @Column(name = "year")
    private int year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "directors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @JsonIgnoreProperties({"actorOf", "directorOf", "hibernateLazyInitializer"})
    private List<Person> directors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "stars",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    @JsonIgnoreProperties({"actorOf", "directorOf", "hibernateLazyInitializer"})
    private List<Person> stars;

    @Transient
    private String moviePoster;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId && year == movie.year && Objects.equals(movieName, movie.movieName) && Objects.equals(directors, movie.directors) && Objects.equals(stars, movie.stars) && Objects.equals(moviePoster, movie.moviePoster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName, year, directors, stars, moviePoster);
    }
}
