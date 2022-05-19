package com.group31.bestmovies.Webservice.Api;

import com.group31.bestmovies.Model.Person;
import com.group31.bestmovies.Webservice.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<Person> getPersonById(@RequestParam("personId") long personId) {
        return ResponseEntity.ok().body(personService.getPersonById(personId));
    }

    @GetMapping("/person/{personName}")
    public ResponseEntity<List<Person>> getPersonByName(@PathVariable String personName) {
        return ResponseEntity.ok().body(personService.getPersonByName(personName));
    }
}
