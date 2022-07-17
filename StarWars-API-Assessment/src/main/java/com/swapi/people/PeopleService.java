package com.swapi.people;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class PeopleService {

    // Service method to get all people data from the Swapi API
    public PeopleData findAllPeople(String uri) throws IOException {

        //String uri = "https://swapi.dev/api/people/?page="+pageNumber;
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        PeopleData result = restTemplate.getForObject(uri, PeopleData.class);

        System.out.println(result.toString());
        return result;
    }
}
