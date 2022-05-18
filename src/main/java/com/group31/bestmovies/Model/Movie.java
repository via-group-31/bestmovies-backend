package com.group31.bestmovies.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private short year;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Rating rating;

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
}
