package com.group31.bestmovies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "dbo")
public class Rating {

    @Id
    @Column(name = "ratingId")
    private long ratingId;

    @Column(name = "movie_Id")
    private long movieId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "votes")
    private int votes;
}
