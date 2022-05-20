package com.group31.bestmovies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "dbo")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private long userId;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "userpassword")
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "movielist",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Movie> movieList;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<UserRole> userRoles = new ArrayList<>();
}
