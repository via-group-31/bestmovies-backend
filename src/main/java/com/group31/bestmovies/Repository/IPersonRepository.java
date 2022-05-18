package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByPersonName(String personName);
}
