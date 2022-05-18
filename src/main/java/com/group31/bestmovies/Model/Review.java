package com.group31.bestmovies.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews", schema = "dbo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewid")
    private long reviewId;

    @ManyToOne
    @JoinColumn(name = "userid")
    // Hide these fields, as it is public and should not be visible by other users
    @JsonIgnoreProperties({"userPassword", "movieList", "userRoles"})
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "reviewcontent")
    private String reviewContent;
}
