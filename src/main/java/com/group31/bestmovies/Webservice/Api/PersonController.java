package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Person;
import com.group31.bestmovies.Webservice.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/person")
public class PersonController {

    private  final PersonService personService;

    @GetMapping
    public ResponseEntity<Person> getPersonById(@RequestParam("personId") long personId){
        return ResponseEntity.ok().body(personService.getPersonById(personId));
    }
}
