package com.group31.bestmovies.Webservice.Service;

import com.group31.bestmovies.Model.Person;
import com.group31.bestmovies.Repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PersonService {

    private final IPersonRepository personRepository;

    public Person getPersonById(long personId) {
        Person person = personRepository.getById(personId);
        person.setPersonImage(getPersonImage(person));
        return person;
    }

    public List<Person> getPersonByName(String personName) {
        return personRepository.findByName(personName);
    }

    private String getPersonImage(Person person){
        RestTemplate restTemplate = new RestTemplate();

        String personId = String.format("%07d", person.getPersonId());

        String uri = "https://imdb-api.com/en/API/Name/k_zo49om6d/nm" + personId;
        String imdb = restTemplate.getForObject(uri, String.class);

        final String regex = ",\\\"image\\\":\\\"(.*?)\\\",\"summary\"";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(imdb);

        String image = "";

        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                image = matcher.group(1);
            }
        }

        return image;
    }
}
