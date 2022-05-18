package com.group31.bestmovies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews", schema = "dbo")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private long reviewId;

    @ManyToOne()
    @JoinColumn(name = "userId")
    private UserModel userModel;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "reviewContent")
    private String reviewContent;
}
