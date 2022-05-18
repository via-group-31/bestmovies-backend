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
@Table(name = "people", schema = "dbo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonModel {
    @Id
    @Column(name = "id")
    private long personId;

    @Column(name = "name")
    private String personName;

    @Column(name = "birth")
    private Integer personBirth;

    @ManyToMany(mappedBy = "directors", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"stars", "directors", "hibernateLazyInitializer"})
    private List<MovieModel> directorOf;

    @ManyToMany(mappedBy = "stars", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"stars", "directors", "hibernateLazyInitializer"})
    private List<MovieModel> actorOf;
}
