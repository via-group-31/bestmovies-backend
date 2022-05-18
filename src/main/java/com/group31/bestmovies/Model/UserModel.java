package com.group31.bestmovies.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "dbo")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Movie> movieList;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<UserRole> userRoleCollections = new ArrayList<>();
}
