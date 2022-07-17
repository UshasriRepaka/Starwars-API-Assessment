package com.swapi.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    private String url = "https://swapi.dev/api/people";
    //Get method to get call get all people service method
    @GetMapping("/people")
    PeopleData getAllPeople() throws IOException {

        return peopleService.findAllPeople(url);
    }

}

