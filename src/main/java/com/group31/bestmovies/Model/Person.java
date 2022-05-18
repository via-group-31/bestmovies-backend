package com.group31.bestmovies.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people", schema = "dbo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {
    @Id
    @Column(name = "id")
    private long personId;

    @Column(name = "name")
    private String personName;

    @Column(name = "birth")
    private Integer personBirth;

    @ManyToMany(mappedBy = "directors", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"stars", "directors", "hibernateLazyInitializer"})
    private List<Movie> directorOf;

    @ManyToMany(mappedBy = "stars", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"stars", "directors", "hibernateLazyInitializer"})
    private List<Movie> actorOf;
}
