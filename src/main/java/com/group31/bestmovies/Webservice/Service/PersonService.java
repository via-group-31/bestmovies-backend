package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.PersonModel;
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

    public List<PersonModel> getPersonsByName(String personName){
        log.info("Getting person by name: {}", personName);
        return personRepository.findAllByPersonName(personName);
    }

    public PersonModel getPersonById(long personId){
        return personRepository.getById(personId);
    }
}
