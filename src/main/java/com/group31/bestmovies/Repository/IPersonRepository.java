package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByPersonName(String personName);

    @Query(value = "SELECT TOP 8 * FROM Movies.dbo.people WHERE name LIKE %:personName%", nativeQuery = true)
    List<Person> findByName(@Param("personName") String personName);
}
