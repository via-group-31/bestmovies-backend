package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Person;
import com.group31.bestmovies.Repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PersonService {

    private final IPersonRepository personRepository;

    public Person getPersonById(long personId) {
        return personRepository.getById(personId);
    }

    public List<Person> getPersonByName(String personName) {
        return personRepository.findByName(personName);
    }
}
